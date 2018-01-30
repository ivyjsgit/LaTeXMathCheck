import com.udojava.evalex.Expression;

import java.math.BigDecimal;

public class EquationChecker {
    public static boolean checkEquation(String providedEquation){
        BigDecimal providedResult = EquationParser.afterEquals(providedEquation);
        String equation = EquationParser.beforeEquals(providedEquation);
        Expression equationAsExpression= new Expression(equation);
        BigDecimal calculatedResult = equationAsExpression.eval();
        return calculatedResult.equals(providedResult);
    }
}
