import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String output = FileManager.openFile("/Users/ivy/Desktop/TexTesting/testMe.tex");
        // System.out.println(output);

        ArrayList<String> returnedEquations = EquationParser.getEquations(output);
        for (int i = 0; i < returnedEquations.size(); i++) {

            String correctAnswer = EquationChecker.getCorrectEquation(returnedEquations.get(i));
            System.out.println("CorrectAnswer:" + correctAnswer);
            if (!correctAnswer.equals(""))
                returnedEquations.set(i, correctAnswer);
        }
        for (String s : returnedEquations) {
            System.out.println(s);
        }
    }

}
