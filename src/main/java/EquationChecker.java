import com.udojava.evalex.Expression;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

public class EquationChecker {
<<<<<<< HEAD
//    public static boolean isEquationTrue(String providedEquation) {
//        if (EquationParser.isFunction(providedEquation)) {
//            String equation = EquationParser.beforeEquals(providedEquation);
//
//            boolean isCorrect = (getCalculatedAnswer(equation).equals(getSuppliedAnswer(providedEquation)));
//            return isCorrect;
//        }
//        return false;
//    }

    public static BigDecimal getCalculatedAnswer(String equation) {

        Expression equationAsExpression = new Expression(equation);
        BigDecimal calculatedResult = equationAsExpression.eval();
        return calculatedResult;

=======
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
>>>>>>> master
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
            String equationBeforeEquals = EquationParser.beforeEquals(providedEquation);
            BigDecimal calculatedAnswer = getCalculatedAnswer(equationBeforeEquals);

            BigDecimal suppliedAnswer = getSuppliedAnswer(providedEquation);

            if (!calculatedAnswer.equals(suppliedAnswer)) {
                providedEquation = "$" + equationBeforeEquals + "=" + calculatedAnswer + "$";
            }
        }
        return providedEquation;

    }

    public static ArrayList<String> correctAllAnswers(ArrayList<String> equationArrayList) {
        for (int currentEquation = 0; currentEquation < equationArrayList.size(); currentEquation++) {
            boolean wasOriginallyEquation =EquationParser.isFunction(equationArrayList.get(currentEquation));
            String correctAnswer = EquationChecker.getCorrectEquation(equationArrayList.get(currentEquation));
           correctAnswer= StringUtils.remove(correctAnswer,"$");
            if(wasOriginallyEquation){
                correctAnswer="$"+correctAnswer+"$";
            }
            if (!correctAnswer.equals(""))
                equationArrayList.set(currentEquation, correctAnswer);
        }

        return equationArrayList;

    }

}
