package EquationParsing;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

public class EquationParser {

    public static ArrayList<String> getEquations(String docAsString) {
        ArrayList<String> output = new ArrayList<>();
        String[] stringAsArray = docAsString.split("\\n");
        for (String line : stringAsArray) {
            output.add(line);
        }
        return output;
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
        //        System.out.println(containsExtraSymbols(string));
//        isFunction=isFunction&&containsExtraSymbols(string);
        return isFunction;
    }
//    public static boolean containsExtraSymbols(String equation){
//
//        List<String> illegalSymbols = Arrays.asList(("\\alpha \\theta o \\tau \n" +
//                "\\beta \\vartheta \\pi \\upsilon \n" +
//                "\\gamma \\gamma \\varpi \\phi \n" +
//                "\\delta \\kappa \\rho \\varphi \n" +
//                "\\epsilon \\lambda \\varrho \\chi \n" +
//                "\\varepsilon \\mu \\sigma \\psi \n" +
//                "\\zeta \\nu \\varsigma \\omega \n" +
//                "\\eta \\xi \n" +
//                "\\Gamma \\Lambda \\Sigma \\Psi \n" +
//                "\\Delta \\Xi \\Upsilon \\Omega \n" +
//                "\\Theta").split("\\s+"));
//        for(String symbol: illegalSymbols){
//            if(equation.contains(symbol)){
//                return false;
//            }
//        }
//        return true;
//    }
}
