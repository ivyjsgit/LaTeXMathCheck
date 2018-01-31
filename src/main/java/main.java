import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String output = FileOpener.openFile("/Users/ivy/Desktop/TexTesting/testMe.tex");
        System.out.println(output);

        ArrayList<String> returnedEquations = EquationParser.getEquations(output);
        for (String equation : returnedEquations) {
            System.out.println(EquationChecker.checkEquation(equation));
        }
    }
}
