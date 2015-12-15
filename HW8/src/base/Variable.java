package base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class Variable implements Expression {

    private String var;

    public Variable(String var) {
        this.var = var;
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = new HashSet<>();
        set.add(this);
        return set;
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variable variable = (Variable) o;

        return !(var != null ? !var.equals(variable.var) : variable.var != null);

    }

    @Override
    public int hashCode() {
        return var != null ? var.hashCode() : 0;
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (equals(var))
            return exp;
        return this;
    }

    public boolean equals(Variable v) {
        return this.var.equals(v.var);
    }

    @Override
    public String toString() {
        return var;
    }
}
