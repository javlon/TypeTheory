package base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class In implements SpecialFrom {
    final private int hasArgs;

    final private boolean isLeft;

    final private Expression expression;

    public In(boolean isLeft, Expression expression) {
        this.isLeft = isLeft;
        this.expression = expression;
        hasArgs = 1;
    }

    public In(boolean isLeft) {
        hasArgs = 0;
        this.isLeft = isLeft;
        expression = null;
    }

    public Expression get() {
        return expression;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isFull() {
        return hasArgs != 0;
    }

    @Override
    public String toString() {
        String s = "In";
        if (isLeft) {
            s += "L ";
        } else {
            s += "R ";
        }
        if (hasArgs != 0) {
            s += expression;
        }
        return s;
    }

    @Override
    public Expression takeArg(Object o) {
        if (hasArgs == 0) {
            if (o instanceof Expression)
                return new In(isLeft, (Expression) o);
            throw new IllegalArgumentException("Expected Expression: " + o);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = new HashSet<>();
        if (hasArgs > 0)
            set.addAll(expression.freeVar());
        return set;
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        if (hasArgs == 0)
            return this;
        throw new IllegalArgumentException("why?");
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (hasArgs == 0)
            return this;
        if (expression.freeVar().contains(var))
            return new In(isLeft, expression.substitution(var, exp));
        return this;
    }
}
