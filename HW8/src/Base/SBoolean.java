package Base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class SBoolean implements Expression {
    private boolean a;

    public SBoolean(boolean a) {
        this.a = a;
    }

    public boolean get() {
        return a;
    }

    @Override
    public String toString() {
        return String.valueOf(a);
    }

    @Override
    public Set<Variable> freeVar() {
        return new HashSet<>();
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        return this;
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        return this;
    }
}
