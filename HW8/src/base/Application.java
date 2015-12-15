package base;

import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class Application implements Expression {

    private Expression left;
    private Expression right;

    public Application(Expression left, Expression right) {
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
        return "(" + left + " " + right + ")";
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = left.freeVar();
        set.addAll(right.freeVar());
        return set;
    }


    @Override
    public Expression reduction(boolean needAbstraction) {
        Expression l = left;
        Expression r = right;
        if (l instanceof Abstraction)
            return ((Abstraction) l).getExpression().substitution(((Abstraction) l).getVar(), new Memorize(r)).reduction(needAbstraction);
        left = left.reduction(true);
        l = left;
        if (l instanceof Abstraction)
            return ((Abstraction) l).getExpression().substitution(((Abstraction) l).getVar(), new Memorize(r)).reduction(needAbstraction);
        if (l instanceof SpecialFrom)
            return ((SpecialFrom) l).takeArg(r).reduction(needAbstraction);
        right = right.reduction(false);
        return new Application(left, right);

    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        Expression l = left;
        Expression r = right;
        boolean f = left.freeVar().contains(var);
        boolean s = right.freeVar().contains(var);
        if (!f && !s)
            return this;
        if (f)
            l = left.substitution(var, exp);
        if (s)
            r = right.substitution(var, exp);
        return new Application(l, r);
    }

}
