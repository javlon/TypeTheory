package Base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class SPair implements Expression {
    private Expression left;
    private Expression right;

    public SPair(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }


    @Override
    public String toString() {
        return "<" + left + "," + right + ">";
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = new HashSet<>();
        set.addAll(left.freeVar());
        set.addAll(right.freeVar());
        return set;
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        left = left.reduction(false);
        right = right.reduction(false);
        return this;
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        boolean bl = left.freeVar().contains(var);
        boolean br = right.freeVar().contains(var);
        Expression el = left;
        Expression er = right;
        if (bl)
            el = left.substitution(var, exp);
        if (br)
            er = right.substitution(var, exp);
        if (bl || br)
            return new SPair(el, er);
        return this;
    }
}
