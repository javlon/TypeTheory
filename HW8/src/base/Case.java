package base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class Case implements SpecialFrom {
    final private int hasArgs;

    final private Expression in;
    final private Expression l;
    final private Expression r;


    public Case(Expression in, Expression l, Expression r) {
        this.r = r;
        this.l = l;
        this.in = in;
        hasArgs = 3;
    }

    public Case(Expression in, Expression l) {
        hasArgs = 2;
        this.in = in;
        this.l = l;
        r = null;
    }

    public Case(Expression in) {
        hasArgs = 1;
        this.in = in;
        l = null;
        r = null;
    }

    public Case() {
        hasArgs = 0;
        in = null;
        l = null;
        r = null;
    }


    @Override
    public String toString() {
        return "(Case " + in + " " + l + " " + r + ")";
    }

    @Override
    public Expression takeArg(Object o) {
        if (hasArgs == 0) {
            if (o instanceof Expression) {
                return new Case((Expression) o);
            }
            throw new IllegalArgumentException("Expected Expression: " + o);
        } else if (hasArgs == 1) {
            if (o instanceof Expression) {
                return new Case(in, (Expression) o);
            }
            throw new IllegalArgumentException("Expected Expression: " + o);
        } else if (hasArgs == 2) {
            if (o instanceof Expression) {
                return new Case(in, l, (Expression) o);
            }
            throw new IllegalArgumentException("Expected Expression: " + o);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = new HashSet<>();
        if (hasArgs > 0) {
            set.addAll(in.freeVar());
        }
        if (hasArgs > 1) {
            set.addAll(l.freeVar());
        }
        if (hasArgs > 2) {
            set.addAll(r.freeVar());
        }
        return set;
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        if (hasArgs < 3)
            return this;
        Expression f = in.reduction(false);
        if (f instanceof In) {
            if (((In) f).isFull())
                return ((In) f).isLeft() ?
                        new Application(l, ((In) f).get()).reduction(needAbstraction) :
                        new Application(r, ((In) f).get()).reduction(needAbstraction);
            throw new IllegalArgumentException("In - not full: " + f);
        }
        throw new IllegalArgumentException("in - is not instance of In: " + in);
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (hasArgs == 0) {
            return this;
        } else if (hasArgs == 1) {
            if (in.freeVar().contains(var))
                return new Case(in.substitution(var, exp));
            return this;
        } else if (hasArgs == 2) {
            boolean tin = in.freeVar().contains(var);
            boolean tl = l.freeVar().contains(var);
            Expression fin = in;
            Expression fl = l;
            if (tin)
                fin = in.substitution(var, exp);
            if (tl)
                fl = l.substitution(var, exp);
            if (!tin && !tl)
                return this;
            return new Case(fin, fl);
        }
        boolean tin = in.freeVar().contains(var);
        boolean tl = l.freeVar().contains(var);
        boolean tr = r.freeVar().contains(var);
        Expression fin = in;
        Expression fl = l;
        Expression fr = r;
        if (tin)
            fin = in.substitution(var, exp);
        if (tl)
            fl = l.substitution(var, exp);
        if (tr)
            fr = r.substitution(var, exp);
        if (!tin && !tl && !tr)
            return this;
        return new Case(fin, fl, fr);
    }
}
