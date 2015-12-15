package types;

import unific.Equation;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by javlon on 13.12.15.
 */
public interface Type {
    public Set<TypeVariable> freeTypeVar();
    public Type substitution(TypeVariable var, Type typeSub);
    public Type substitution(Map<TypeVariable, Type> map);
    public boolean sameFunction(Type t);
    public List<Equation> decompose(Type t);
}
