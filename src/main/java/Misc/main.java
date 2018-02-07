package Misc;

import java.util.Arrays;
import java.util.List;

public class main {

    public static void main(String[] args) {
        List<String> newList = Arrays.asList(("\\alpha \\theta o \\tau \n" +
                "\\beta \\vartheta \\pi \\upsilon \n" +
                "\\gamma \\gamma \\varpi \\phi \n" +
                "\\delta \\kappa \\rho \\varphi \n" +
                "\\epsilon \\lambda \\varrho \\chi \n" +
                "\\varepsilon \\mu \\sigma \\psi \n" +
                "\\zeta \\nu \\varsigma \\omega \n" +
                "\\eta \\xi \n" +
                "\\Gamma \\Lambda \\Sigma \\Psi \n" +
                "\\Delta \\Xi \\Upsilon \\Omega \n" +
                "\\Theta").split("\\s+"));
        System.out.println(newList.size());
    }
}
