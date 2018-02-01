import com.udojava.evalex.Expression;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;

public class EquationChecker {
    public static boolean isEquationTrue(String providedEquation) {
        if (EquationParser.isFunction(providedEquation)) {
            String equation = EquationParser.beforeEquals(providedEquation);

            boolean isCorrect = (getCalculatedAnswer(equation).equals(getSuppliedAnswer(providedEquation)));
            return isCorrect;
        }
        return false;
    }

    public static BigDecimal getCalculatedAnswer(String equation) {

        Expression equationAsExpression = new Expression(equation);
        BigDecimal calculatedResult = equationAsExpression.eval();
        return calculatedResult;

    }

    public static BigDecimal getSuppliedAnswer(String equation) {

        if (EquationParser.isFunction(equation)) {
            BigDecimal providedResult = EquationParser.afterEquals(equation);
            return providedResult;
        }
        return null;
    }

    public static String getCorrectEquation(String providedEquation) {

        if (EquationParser.isFunction(providedEquation)) {
            String equation = EquationParser.beforeEquals(providedEquation);
            BigDecimal calculatedAnswer = getCalculatedAnswer(equation);

            BigDecimal suppliedAnswer = getSuppliedAnswer(providedEquation);

            if (!calculatedAnswer.equals(suppliedAnswer)) {
                providedEquation = "$" + equation + "=" + calculatedAnswer + "$";
            }
            return providedEquation;
        }
        return providedEquation;

    }

    public static ArrayList<String> correctAllAnswers(ArrayList<String> equationArrayList) {
        for (int i = 0; i < equationArrayList.size(); i++) {

            String correctAnswer = EquationChecker.getCorrectEquation(equationArrayList.get(i));
            if (!correctAnswer.equals(""))

                equationArrayList.set(i, correctAnswer);
        }

        return equationArrayList;

    }

}
