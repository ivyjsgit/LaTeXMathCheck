import com.udojava.evalex.Expression;

import java.math.BigDecimal;

public class EquationChecker {
	/**
	 * Check if provided equation matches computer answer.
	 * @param providedEquation
	 * @return
	 */
    public static boolean checkEquation(String providedEquation){
        BigDecimal providedResult = EquationParser.afterEquals(providedEquation);
        String equation = EquationParser.beforeEquals(providedEquation);

        Expression equationAsExpression= new Expression(equation);
        BigDecimal calculatedResult = equationAsExpression.eval();

        return calculatedResult.equals(providedResult);
    }
}
