package base;

import java.util.Set;

/**
 * Created by javlon on 12.12.15.
 */
public class Memorize implements Expression {

    private Expression expression;

    public Memorize(Expression expression) {
        this.expression = expression;
    }


    @Override
    public Set<Variable> freeVar() {
        return expression.freeVar();
    }

    @Override
    public Expression reduction(boolean needAbstraction) {
        if(expression instanceof Abstraction && needAbstraction){
            return expression;
        }
        expression = expression.reduction(needAbstraction);
        while (expression instanceof Memorize)
            expression = ((Memorize) expression).expression;
        return expression;
    }

    @Override
    public Expression substitution(Variable var, Expression exp) {
        if (expression.freeVar().contains(exp))
            return expression.substitution(var, exp);
        return this;
    }
}
