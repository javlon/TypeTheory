package Base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class Y implements SpecialFrom {

    private final int hasArgs;
    final private Expression f;

    public Y() {
        f = null;
        hasArgs = 0;
    }

    public Y(Expression f) {
        this.f = f;
        hasArgs = 1;
    }

    @Override
    public String toString() {
        if (hasArgs == 1)
            return "(Y " + f + ")";
        return "Y";
    }

    @Override
    public Expression takeArg(Object o) {
        if (hasArgs == 0) {
            if (o instanceof Expression)
                return new Y((Expression) o);
            throw new IllegalArgumentException("Expected Expression: " + o);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = new HashSet<>();
        if (hasArgs > 0)
            set.addAll(f.freeVar());
        return set;
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        if (hasArgs == 0)
            return this;
        return new Application(f, this).reduction(needAbstraction);
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (hasArgs == 1)
            if (f.freeVar().contains(var))
                return new Y(f.substitution(var, exp));
        return this;
    }
}
