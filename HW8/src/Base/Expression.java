package Base;

import java.util.Set;

/**
 * Created by javlon on 10.12.15.
 */
public interface Expression {
    public Set<Variable> freeVar();

    public Expression reduction(boolean needAbstraction);

    public Expression substitution(Variable var, Expression exp);
}
