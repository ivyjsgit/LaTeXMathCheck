package EquationParsing;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class EquationParser {

    public static ArrayList<String> getEquations(String docAsString) {
        ArrayList<String> inputWithoutWhitespace = new ArrayList<>(Arrays.asList(((String[]) docAsString.split("\\n"))));
        return inputWithoutWhitespace;
    }

    public static String beforeEquals(String equation) {
        String beforeEquals = StringUtils.remove(StringUtils.substringBefore(equation, "="), "$");
        beforeEquals = beforeEquals.replace("\\pi", "PI");
        return beforeEquals;
    }

    public static BigDecimal afterEquals(String equation) {
        String afterEquals = StringUtils.remove(StringUtils.substringAfter(equation, "="), "$");
        return new BigDecimal(afterEquals);


    }

    public static boolean isFunction(String string) {
        boolean isFunction = StringUtils.startsWith(string, "$") && (StringUtils.endsWith(string, "$") || StringUtils.endsWith(string, "$\n"));
        return isFunction;
    }
}
