import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class EquationParser {
    public static ArrayList<String> getEquations(String docAsString){
     return new ArrayList(Arrays.asList(StringUtils.substringsBetween(docAsString,"$","$")));
    }
    public static String beforeEquals(String equation){
        return StringUtils.substringBefore(equation,"=");
    }
    public static BigDecimal afterEquals(String equation){
        return new BigDecimal(StringUtils.substringAfter(equation,"="));
    }
}
