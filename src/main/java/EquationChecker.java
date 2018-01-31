import com.udojava.evalex.Expression;

import java.math.BigDecimal;

public class EquationChecker {
    public static boolean isEquationTrue(String providedEquation) {
        String equation = EquationParser.beforeEquals(providedEquation);
        boolean isCorrect = (getCalculatedAnswer(equation).equals(getSuppliedAnswer(providedEquation)));
        return isCorrect;

    }

    public static BigDecimal getCalculatedAnswer(String equation) {
        Expression equationAsExpression = new Expression(equation);
        BigDecimal calculatedResult = equationAsExpression.eval();
        return calculatedResult;
    }

    public static BigDecimal getSuppliedAnswer(String equation) {
        BigDecimal providedResult = EquationParser.afterEquals(equation);
        return providedResult;
    }

    public static String getCorrectEquation(String providedEquation) {
        String equation = EquationParser.beforeEquals(providedEquation);
        BigDecimal calculatedAnswer = getCalculatedAnswer(equation);
        BigDecimal suppliedAnswer = getSuppliedAnswer(providedEquation);

        if (!calculatedAnswer.equals(suppliedAnswer)) {
            providedEquation = equation + "=" + calculatedAnswer;
        }
        return providedEquation;

    }

}
