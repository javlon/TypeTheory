package Types;

import Unific.Equation;

import java.util.*;

/**
 * Created by javlon on 13.12.15.
 */
public class Implication implements Type {
    private final Type left;
    private final Type right;

    public Implication(Type left, Type right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Set<TypeVariable> freeTypeVar() {
        Set<TypeVariable> set = new HashSet<>();
        set.addAll(left.freeTypeVar());
        set.addAll(right.freeTypeVar());
        return set;
    }

    @Override
    public Type substitution(TypeVariable var, Type typeSub) {
        return new Implication(left.substitution(var, typeSub), right.substitution(var, typeSub));
    }

    @Override
    public Type substitution(Map<TypeVariable, Type> map) {
        return new Implication(left.substitution(map), right.substitution(map));
    }

    @Override
    public boolean sameFunction(Type t) {
        return t instanceof Implication;
    }


    @Override
    public List<Equation> decompose(Type t) {
        if (!sameFunction(t))
            throw new IllegalArgumentException();
        List<Equation> list = new ArrayList<>();
        list.add(new Equation(left, ((Implication) t).left));
        list.add(new Equation(right, ((Implication) t).right));
        return list;
    }

    @Override
    public String toString() {
        return "(" + left + " -> " + right + ")";
    }
}
