package Base;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class LetIn implements Expression {

    private Variable var;
    private Expression sub;
    private Expression expression;

    public LetIn(Variable var, Expression sub, Expression expression) {
        this.var = var;
        this.sub = sub;
        this.expression = expression;
    }

    public Variable getVar() {
        return var;
    }

    public Expression getSub() {
        return sub;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "(Let " + var + " = " + sub + " In " + expression + ")";
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = new HashSet<>();
        set.addAll(sub.freeVar());
        set.addAll(expression.freeVar());
        set.remove(var);
        return set;
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        return expression.substitution(var, sub).reduction(needAbstraction);
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (var.equals(this.var))
            return this;
        boolean bs = sub.freeVar().contains(var);
        boolean be = expression.freeVar().contains(var);
        Expression es = sub;
        Expression ee = expression;
        if (bs)
            es = sub.substitution(var, exp);
        if (be)
            ee = expression.substitution(var, exp);
        if (bs || be)
            return new LetIn(this.var, es, ee);
        return this;
    }
}
