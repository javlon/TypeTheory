package Base;

import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public class Abstraction implements Expression {
    private Variable var;
    private Expression expression;

    public Abstraction(Variable var, Expression expression) {
        this.var = var;
        this.expression = expression;
    }

    public Variable getVar() {
        return var;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public Set<Variable> freeVar() {
        Set<Variable> set = expression.freeVar();
        set.remove(var);
        return set;
    }


    @Override
    public Expression reduction(boolean needAbstraction) {
        if (needAbstraction)
            return this;
        expression = expression.reduction(false);
        return this;
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (var.equals(this.var))
            return this;
        if (expression.freeVar().contains(var))
            return new Abstraction(this.var, expression.substitution(var, exp));
        return this;
    }

    @Override
    public String toString() {
        return "(\\" + var + '.' + expression + ")";
    }
}
