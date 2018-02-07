package EquationParsing;

import com.udojava.evalex.Expression;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

public class EquationChecker {
    public static boolean isEquationFalse(String providedEquation) {
        if (EquationParser.isFunction(providedEquation)) {
            String equation = EquationParser.beforeEquals(providedEquation);

            boolean isCorrect = (getCalculatedAnswer(equation).equals(getSuppliedAnswer(providedEquation)));
            return !isCorrect;
        }
        return true;
    }

    //Evalex https://github.com/uklimaschewski/EvalEx
    //uklimaschewski github
    public static BigDecimal getCalculatedAnswer(String equation) {
        equation = EquationParser.beforeEquals(equation);
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

    private static String getCorrectEquation(String providedEquation) {

        if (EquationParser.isFunction(providedEquation)) {
            String equationBeforeEquals = EquationParser.beforeEquals(providedEquation);
            BigDecimal calculatedAnswer = getCalculatedAnswer(equationBeforeEquals);

            BigDecimal suppliedAnswer = getSuppliedAnswer(providedEquation);

            if (!calculatedAnswer.equals(suppliedAnswer)) {
                providedEquation = "$" + equationBeforeEquals + "=" + calculatedAnswer + "$";
                providedEquation = providedEquation.replace("PI", "\\pi");
            }
        }
        return providedEquation;

    }

    public static ArrayList<String> correctAllAnswers(ArrayList<String> originalArrayList) {
        ArrayList<String> equationArrayList = (ArrayList<String>) originalArrayList.clone();
        for (int currentEquation = 0; currentEquation < equationArrayList.size(); currentEquation++) {
            String correctAnswer=correctOneAnswer(equationArrayList.get(currentEquation));
            if (!correctAnswer.equals(""))
                equationArrayList.set(currentEquation, correctAnswer);
        }

        return equationArrayList;

    }
    private static String correctOneAnswer(String currentEquation){
        boolean wasOriginallyEquation = EquationParser.isFunction(currentEquation);
        String correctAnswer = EquationChecker.getCorrectEquation(currentEquation);
        correctAnswer = StringUtils.remove(correctAnswer, "$");
        if (wasOriginallyEquation) {
            correctAnswer = "$" + correctAnswer + "$";
        }
        return correctAnswer;
    }

}
