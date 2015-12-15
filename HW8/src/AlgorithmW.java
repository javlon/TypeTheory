import Base.*;
import Types.*;
import Unific.Equation;
import Unific.Solving;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by javlon on 13.12.15.
 */
public class AlgorithmW {
    static final TypeVariable BOOL = new TypeVariable("Bool");
    static final TypeVariable INT = new TypeVariable("Int");

    public static Map<TypeVariable, Type> composition(Map<TypeVariable, Type> last, Map<TypeVariable, Type> front) {
        Map<TypeVariable, Type> map = new HashMap<>();
        map.putAll(front);
        for (TypeVariable tv : last.keySet()) {
            if (map.containsKey(tv)) {
                continue;
            }
            for (TypeVariable v : map.keySet()) {
                map.put(v, map.get(v).substitution(tv, last.get(tv)));
            }
            map.put(tv, last.get(tv));
        }
        return map;
    }

    public static Map<Variable, TypeScheme> contextSub(Map<TypeVariable, Type> sub, Map<Variable, TypeScheme> context) {
        Map<Variable, TypeScheme> ret = new HashMap<>();
        for (Variable v : context.keySet()) {
            ret.put(v, context.get(v).substitution(sub));
        }
        return ret;
    }


    public static Pair<Map<TypeVariable, Type>, Type> algoW(Map<Variable, TypeScheme> map, Expression exp) {
        TypeVariable alfa = TypeVariable.nextFresh();
        TypeVariable betta = TypeVariable.nextFresh();
        TypeVariable gamma = TypeVariable.nextFresh();
        Map<TypeVariable, Type> newMap = new HashMap<>();
        if (exp instanceof SBoolean) {
            return new Pair<>(newMap, BOOL);
        } else if (exp instanceof SNumber) {
            return new Pair<>(newMap, INT);
        } else if (exp instanceof Plus || exp instanceof Minus) {
            return new Pair<>(newMap, new Implication(INT, new Implication(INT, INT)));
        } else if (exp instanceof Eq) {
            return new Pair<>(newMap, new Implication(INT, new Implication(INT, BOOL)));
        } else if (exp instanceof If) {
            return new Pair<>(newMap, new Implication(BOOL, new Implication(alfa, new Implication(alfa, alfa))));
        } else if (exp instanceof SPair) {
            Pair<Map<TypeVariable, Type>, Type> w1 = algoW(map, ((SPair) exp).getLeft());
            if(w1.getKey() == null && w1.getValue() == null)    return w1;
            Pair<Map<TypeVariable, Type>, Type> w2 = algoW(contextSub(w1.getKey(), map), ((SPair) exp).getRight());
            if(w2.getKey() == null && w2.getValue() == null)    return w2;
            return new Pair<>(composition(w2.getKey(), w1.getKey()), new Conjunction(w1.getValue().substitution(w2.getKey()), w2.getValue()));
        } else if (exp instanceof Pr) {
            return new Pair<>(newMap, new Implication(new Conjunction(alfa, betta), ((Pr) exp).isLeft() ? alfa : betta));
        } else if (exp instanceof In) {
            return new Pair<>(newMap, new Implication(((In) exp).isLeft() ? alfa : betta, new Disjunction(alfa, betta)));
        } else if (exp instanceof Case) {
            return new Pair<>(newMap, new Implication(new Disjunction(alfa, betta), new Implication(new Implication(alfa, gamma), new Implication(new Implication(betta, gamma), gamma))));
        } else if (exp instanceof Y) {
            return new Pair<>(newMap, new Implication(new Implication(alfa, alfa), alfa));
        } else if (exp instanceof Variable) {
            if (map.containsKey(exp)) return new Pair<>(newMap, map.get(exp).instantiate());
            throw new IllegalArgumentException("Expression has free variables: " + exp);
        } else if (exp instanceof Abstraction) {
            Map<Variable, TypeScheme> tmp = new HashMap<>();
            tmp.putAll(map);
            tmp.put(((Abstraction) exp).getVar(), new TypeScheme(betta));
            Pair<Map<TypeVariable, Type>, Type> w1 = algoW(tmp, ((Abstraction) exp).getExpression());
            if(w1.getKey() == null && w1.getValue() == null)    return w1;
            return new Pair<>(w1.getKey(), new Implication(betta.substitution(w1.getKey()), w1.getValue()));
        } else if (exp instanceof Application) {
            Pair<Map<TypeVariable, Type>, Type> w1 = algoW(map, ((Application) exp).getLeft());
            if(w1.getKey() == null && w1.getValue() == null)    return w1;
            Pair<Map<TypeVariable, Type>, Type> w2 = algoW(contextSub(w1.getKey(), map), ((Application) exp).getRight());
            if(w2.getKey() == null && w2.getValue() == null)    return w2;
            List<Equation> equations = new ArrayList<>();
            equations.add(new Equation(w1.getValue().substitution(w2.getKey()), new Implication(w2.getValue(), betta)));
            if (!Solving.solving(equations))    return new Pair<>(null, null);
            Map<TypeVariable, Type> s3 = new HashMap<>();
            for (Equation eq : equations)
                s3.put((TypeVariable) eq.getLeft(), eq.getRight());
            return new Pair<>(composition(s3, composition(w2.getKey(), w1.getKey())), betta.substitution(s3));
        } else if (exp instanceof LetIn) {
            Pair<Map<TypeVariable, Type>, Type> w1 = algoW(map, ((LetIn) exp).getSub());
            if(w1.getKey() == null && w1.getValue() == null)    return w1;
            Map<Variable, TypeScheme> tmp = new HashMap<>();
            tmp.putAll(map);
            tmp.put(((LetIn) exp).getVar(), TypeScheme.generalize(contextSub(w1.getKey(), map), w1.getValue()));
            Pair<Map<TypeVariable, Type>, Type> w2 = algoW(tmp, ((LetIn) exp).getExpression());
            if(w2.getKey() == null && w2.getValue() == null)    return w2;
            return new Pair<>(composition(w2.getKey(), w1.getKey()), w2.getValue());
        }
        throw new IllegalArgumentException();
    }

}
