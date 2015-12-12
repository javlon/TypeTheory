package Base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class SNumber implements Expression {
    private long a;

    public SNumber(long a) {
        this.a = a;
    }

    public SNumber(String a) {
        this.a = Long.parseLong(a);
    }

    public long get() {
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
