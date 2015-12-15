package Base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class Pr implements SpecialFrom {
    final private int hasArgs;

    final private boolean isLeft;
    private Expression pair;

    public Pr(boolean isLeft) {
        this.isLeft = isLeft;
        hasArgs = 0;
        pair = null;
    }

    public Pr(boolean isLeft, Expression pair) {
        this.isLeft = isLeft;
        this.pair = pair;
        hasArgs = 1;
    }

    public boolean isLeft() {
        return isLeft;
    }

    @Override
    public String toString() {
        if (hasArgs == 1)
            return "(Pr" + (isLeft ? "L " : "R ") + pair + ")";
        return "(Pr" + (isLeft ? "L " : "R ");
    }

    @Override
    public Expression takeArg(Object o) {
        if (hasArgs == 0) {
            if (o instanceof Expression)
                return new Pr(isLeft, (Expression) o);
            throw new IllegalArgumentException("Expected Expression: " + o);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = new HashSet<>();
        if (hasArgs > 0)
            set.addAll(pair.freeVar());
        return set;
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        if (hasArgs == 0)
            return this;
        pair = pair.reduction(false);
        if (pair instanceof SPair)
            return isLeft ? ((SPair) pair).getLeft().reduction(needAbstraction) : ((SPair) pair).getRight().reduction(needAbstraction);
        throw new IllegalArgumentException("Expected SPair: " + pair);
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (hasArgs == 0)
            return this;
        if (pair.freeVar().contains(var))
            return new Pr(isLeft, pair.substitution(var, exp));
        return this;
    }
}
