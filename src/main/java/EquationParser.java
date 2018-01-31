import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class EquationParser {
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
    }
}
