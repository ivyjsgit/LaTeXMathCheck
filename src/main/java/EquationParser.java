import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

public class EquationParser {
<<<<<<< HEAD
    public static ArrayList<String> getEquations(String docAsString) {
        ArrayList<String> output =  new ArrayList<>();
        String[] stringAsArray = docAsString.split("\\n");
        for(String line:stringAsArray){
            output.add(line);
        }
        return output;
    }

    public static String beforeEquals(String equation) {
        String beforeEquals = StringUtils.remove(StringUtils.substringBefore(equation, "="), "$");

        return beforeEquals;
    }

    public static BigDecimal afterEquals(String equation) {
        String afterEquals = StringUtils.remove(StringUtils.substringAfter(equation, "="), "$");


        return new BigDecimal(afterEquals);


    }

    public static boolean isFunction(String string) {
        boolean isFunction = StringUtils.startsWith(string, "$") && (StringUtils.endsWith(string, "$") || StringUtils.endsWith(string, "$\n"));
        return isFunction;


=======
	/**
	 * 
	 * @param docAsString TeX document represented as a string
	 * @return ArrayList of all found equations in the document.
	 */
    public static ArrayList<String> getEquations(String docAsString){
     return new ArrayList(Arrays.asList(StringUtils.substringsBetween(docAsString,"$","$")));
    }
    /**
     * 
     * @param equation
     * @return the part of the equation before the equals sign
     */
    public static String beforeEquals(String equation){
        return StringUtils.substringBefore(equation,"=");
    }
    /**
     * 
     * @param equation
     * @return part of the equation after the equal song
     */
    public static BigDecimal afterEquals(String equation){
        return new BigDecimal(StringUtils.substringAfter(equation,"="));
>>>>>>> master
    }
}
