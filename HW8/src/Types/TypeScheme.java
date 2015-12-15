package Types;

import Base.Variable;

import java.util.*;

/**
 * Created by javlon on 13.12.15.
 */
public class TypeScheme {

    private final Type type;
    private final List<TypeVariable> list;

    public TypeScheme(Type type) {
        this.type = type;
        this.list = new ArrayList<>();
    }
    public TypeScheme(Type type, List<TypeVariable> list) {
        this.type = type;
        this.list = new ArrayList<>();
        this.list.addAll(list);
    }

    public Set<TypeVariable> freeTypeVar(){
        Set<TypeVariable> set = new HashSet<>();
        set.addAll(type.freeTypeVar());
        for (TypeVariable tv : list){
            set.remove(tv);
        }
        return set;
    }

    public Type instantiate(){
        Type t = type;
        for(TypeVariable tt : list){
            t = t.substitution(tt,TypeVariable.nextFresh());
        }
        return t;
    }
    public static TypeScheme generalize(Map<Variable, TypeScheme> context, Type tau){
        Set<TypeVariable> set = new HashSet<>();
        set.addAll(tau.freeTypeVar());
        for(Variable v: context.keySet()){
            set.removeAll(context.get(v).freeTypeVar());
        }
        return new TypeScheme(tau,new ArrayList<>(set));
    }


    public TypeScheme substitution(Map<TypeVariable, Type> sub){
        Map<TypeVariable, Type> tmp = new HashMap<>();
        for(TypeVariable tv: list){
            if(!sub.containsKey(tv)){
                tmp.put(tv, sub.get(tv));
            }
        }
        Type type1 =  type.substitution(sub);
        return new TypeScheme(type1, list);
    }

    @Override
    public String toString() {
        String s = "";
        for(TypeVariable tv: list)
            s += "\\forall"+ tv;
        return s + " " + type + ".";
    }
}
