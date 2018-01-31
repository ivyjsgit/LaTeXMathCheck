import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class unitTests {
    @Test
    public void testEquations() {
        System.out.println("Running tests");
        String trueEquations = "$1+1=2$ $2+2=4$ $1.5+1.5=3$";
        String falseEquations = "$1+1=3$ $2+2=100$";

        ArrayList<String> parsedTrueEquations = EquationParser.getEquations(trueEquations);
        ArrayList<String> parsedFalseEquations = EquationParser.getEquations(falseEquations);

        for (String equation : parsedTrueEquations) {
            Assert.assertTrue(EquationChecker.isEquationTrue(equation));
        }
        for (String equation : parsedFalseEquations) {
            Assert.assertFalse(EquationChecker.isEquationTrue(equation));
        }
    }

    @Test
    public void testOpenFile() {
        String text = FileManager.openFile("/Users/ivy/Desktop/TexTesting/testMe.tex");
        Assert.assertEquals("$3+3=6$\n" +
                "$3+3=6$\n" +
                "$3^2=2$\n" +
                "This is a test sentence", text);
    }

    @Test
    public void testWriteFile() {
        String fileContents = "This\n" +
                "is\n" +
                "a\n" +
                "test";
        String pathName = "/Users/ivy/Desktop/TexTesting/text.txt";
        FileManager.fileSaver(fileContents, pathName);
        Assert.assertEquals(fileContents, FileManager.openFile("/Users/ivy/Desktop/TexTesting/text.txt"));
    }

    @Test
    public void replaceAnswers() {
        String output = FileManager.openFile("/Users/ivy/Desktop/TexTesting/testMe.tex");
        ArrayList<String> outputtedAnswers = new ArrayList<String>();
        ArrayList<String> correctAnswers = new ArrayList<>();
        correctAnswers.add("3+3=6");
        correctAnswers.add("3+3=6");
        correctAnswers.add("3^2=9");
        // System.out.println(output);

        ArrayList<String> returnedEquations = EquationParser.getEquations(output);
        for (int i = 0; i < returnedEquations.size(); i++) {
            returnedEquations.set(i, EquationChecker.getCorrectEquation(returnedEquations.get(i)));
            outputtedAnswers.add(returnedEquations.get(i));
        }

        for (int i = 0; i < outputtedAnswers.size(); i++) {
            Assert.assertTrue(outputtedAnswers.get(i).equals(correctAnswers.get(i)));
        }

    }
}
