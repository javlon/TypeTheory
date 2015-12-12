package Base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class Minus implements SpecialFrom {
    private final int hasArgs;

    private Expression left;
    private Expression right;

    public Minus(Expression left, Expression right) {
        hasArgs = 2;
        this.left = left;
        this.right = right;
    }

    public Minus(Expression left) {
        hasArgs = 1;
        this.left = left;
        right = null;
    }

    public Minus() {
        hasArgs = 0;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        String s = "Minus";
        if (hasArgs >= 1)
            s += " " + left;
        if (hasArgs >= 2)
            s += " " + right;
        return "(" + s + ")";
    }

    @Override
    public Expression takeArg(Object o) {
        if (hasArgs == 0) {
            if (o instanceof Expression)
                return new Minus((Expression) o);
            throw new IllegalArgumentException("Expected Expression: " + o);
        } else if (hasArgs == 1) {
            if (o instanceof Expression)
                return new Minus(left, (Expression) o);
            throw new IllegalArgumentException("Expected Expression: " + o);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = new HashSet<>();
        if (hasArgs > 0)
            set.addAll(left.freeVar());
        if (hasArgs > 1)
            set.addAll(right.freeVar());
        return set;
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        if (hasArgs < 2)
            return this;
        left = left.reduction(false);
        right = right.reduction(false);
        if (left instanceof SNumber && right instanceof SNumber)
            return new SNumber(((SNumber) left).get() - ((SNumber) right).get());
        throw new IllegalArgumentException("Expected SNumbers: \n" + left + "\n" + right);
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (hasArgs == 0) {
            return this;
        } else if (hasArgs == 1) {
            if (left.freeVar().contains(var))
                return new Minus(left.substitution(var, exp));
            return this;
        }
        boolean bl = left.freeVar().contains(var);
        boolean br = right.freeVar().contains(var);
        Expression l = left;
        Expression r = right;
        if (bl)
            l = left.substitution(var, exp);
        if (br)
            r = right.substitution(var, exp);
        if (bl || br)
            return new Minus(l, r);
        return this;
    }
}
