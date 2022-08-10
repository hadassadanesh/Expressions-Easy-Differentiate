/**
 * @author Hadassa Danesh
 * @ID 322567041
 * @version 1.0
 * @since 2020-05-14
 */

import java.util.List;
import java.util.Map;

/**
 * a class that indicating an expression that includes one or two expressions in it.
 */
public abstract class BaseExpression implements Expression {

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result.  If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment contains keys and their values.
     * @return the value of the expression.
     * @throws Exception when: 1. in Div- the second expression is 0.
     *                   2. in Log- when the base is one or less than one, and when the value of the
     *                   second expression is 0 or less than 0.
     */
    public abstract double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     * <p>
     *
     * @return the value of the expression.
     * @throws Exception when: 1. in Div- the second expression is 0.
     *                   2. in Log- when the base is one or less than one, and when the value of the
     *                   second expression is 0 or less than 0.
     */
    public abstract double evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     *
     * @return a list of the variables in the expression.
     */
    public abstract List<String> getVariables();

    /**
     * return a string representation of the expression.
     *
     * @return a string representation of the expression.
     */
    public abstract String toString();

    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        the variable that the method replaces.
     * @param expression the expression that the method will replace the variable to be.
     * @return a new expression in which all occurrences of the variable
     * var are replaced with the provided expression
     */
    public abstract Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     *
     * @param var the variable that the method differentiate the expression according to.
     * @return the expression tree resulting from differentiating
     * the current expression relative to variable `var`.
     */
    public abstract Expression differentiate(String var);

    /**
     * Returned a simplified version of the current expression.
     * <p>
     *
     * @return a simplified version of the current expression.
     */
    public abstract Expression simplify();

    /**
     * a method that handle cases when the expression does not  include variable.
     * at this case, we need to evaluate the expression, and handle a possible exception
     * that can be thrown. in this method, if an exception is thrown from the 'evaluate'
     * method, this method returns the expression.
     * * <p>
     *
     * @return the value of the expression, or the current expression, if an exception was thrown
     * in the 'evaluate' method.
     */
    protected Expression handleExceptionInSimplify() {
        try {
            return new Num(this.evaluate());
        } catch (Exception exception) {
            return this;
        }
    }
}
