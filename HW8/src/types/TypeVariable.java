package types;

import unific.Equation;

import java.util.*;

/**
 * Created by javlon on 13.12.15.
 */
public class TypeVariable implements Type {

    private static int stName = 0;
    public static TypeVariable nextFresh(){
        Random rand = new Random();
        char ch = (char) ('a'+(rand.nextInt(26)));
        String s = ch + String.valueOf(++stName);
        return new TypeVariable(s);
    }

    private final String name;

    public TypeVariable(String name) {
        this.name = name;
    }


    @Override
    public Set<TypeVariable> freeTypeVar() {
        Set<TypeVariable> set = new HashSet<>();
        if (!isPrimaryType())
            set.add(this);
        return set;
    }

    @Override
    public Type substitution(TypeVariable var, Type typeSub) {
        if(var.equals(this)){
            return typeSub;
        }
        return this;
    }

    @Override
    public Type substitution(Map<TypeVariable, Type> map) {
        if(map.containsKey(this)){
            return map.get(this);
        }
        return this;
    }

    @Override
    public boolean sameFunction(Type t) {
        return false;
    }

    @Override
    public List<Equation> decompose(Type t) {
        throw new IllegalArgumentException();
    }

    public boolean isPrimaryType(){
        if(name.charAt(0) >= 'A' &&  name.charAt(0) <= 'Z'){
            return true;
        }
        return false;
    }

    public boolean equals(TypeVariable t){
        return t.name.equals(name);
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeVariable that = (TypeVariable) o;

        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
