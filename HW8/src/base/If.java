package base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class If implements SpecialFrom {
    private final int hasArgs;

    private Expression b;
    private Expression t;
    private Expression e;


    public If() {
        hasArgs = 0;
        b = null;
        t = null;
        e = null;
    }

    public If(Expression b) {
        this.b = b;
        hasArgs = 1;
        t = null;
        e = null;
    }

    public If(Expression b, Expression t) {
        this.b = b;
        this.t = t;
        hasArgs = 2;
        e = null;
    }

    public If(Expression b, Expression t, Expression e) {
        this.b = b;
        this.t = t;
        this.e = e;
        hasArgs = 3;
    }


    @Override
    public String toString() {
        String s = "IF";
        if (hasArgs >= 1)
            s += b;
        if (hasArgs >= 2)
            s += t;
        if (hasArgs >= 3)
            s += e;
        return s;
    }

    @Override
    public Expression takeArg(Object o) {
        if (hasArgs == 0) {
            if (o instanceof Expression)
                return new If((Expression) o);
            throw new IllegalArgumentException("Expected Expression: " + o);
        } else if (hasArgs == 1) {
            if (o instanceof Expression)
                return new If(b, (Expression) o);
            throw new IllegalArgumentException("Expected Expression: " + o);
        } else if (hasArgs == 2) {
            if (o instanceof Expression)
                return new If(b, t, (Expression) o);
            throw new IllegalArgumentException("Expected Expression: " + o);
        }
        throw new IllegalArgumentException();
    }


    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = new HashSet<>();
        if (hasArgs > 0)
            set.addAll(b.freeVar());
        if (hasArgs > 1)
            set.addAll(t.freeVar());
        if (hasArgs > 2)
            set.addAll(e.freeVar());
        return set;
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        if (hasArgs < 3)
            return this;
        b = b.reduction(false);
        if (b instanceof SBoolean) {
            if (((SBoolean) b).get()) {
                t = t.reduction(needAbstraction);
                return t;
            } else {
                e = e.reduction(needAbstraction);
                return e;
            }
        }
        throw new IllegalArgumentException("b - is not instance of SBoolean: " + b);
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (hasArgs == 0) {
            return this;
        } else if (hasArgs == 1) {
            if (b.freeVar().contains(var))
                return new If(b.substitution(var, exp));
            return this;
        } else if (hasArgs == 2) {
            boolean bb = b.freeVar().contains(var);
            boolean bt = t.freeVar().contains(var);
            Expression fb = b;
            Expression ft = t;
            if (bb)
                fb = b.substitution(var, exp);
            if (bt)
                ft = t.substitution(var, exp);
            if (!bb && !bt)
                return this;
            return new If(fb, ft);
        }
        boolean tin = b.freeVar().contains(var);
        boolean tl = t.freeVar().contains(var);
        boolean tr = e.freeVar().contains(var);
        Expression fin = b;
        Expression fl = t;
        Expression fr = e;
        if (tin)
            fin = b.substitution(var, exp);
        if (tl)
            fl = t.substitution(var, exp);
        if (tr)
            fr = e.substitution(var, exp);
        if (!tin && !tl && !tr)
            return this;
        return new If(fin, fl, fr);
    }
}
