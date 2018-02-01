import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;

public class unitTests {
    @Test
    public void testOpenFile() {
        File fileToOpen=new File("/Users/ivy/Desktop/TexTesting/testMe.tex");
        String text = FileManager.stringFromFile(fileToOpen);
        Assert.assertEquals("$3+3=6$\n" +
                "$3+3=6$\n" +
                "$3^2=2$\n" +
                "This is a test sentence\n" +
                "$3^2=2$", text);
    }

    @Test
    public void testWriteFile() {
        String fileContents = "This\n" +
                "is\n" +
                "a\n" +
                "test";

        try {
            File fileToOpen=new File("/Users/ivy/Desktop/TexTesting/txt.tex");
            fileToOpen.createNewFile();
            PrintStream fileOutput = new PrintStream(fileToOpen);

            fileOutput = new PrintStream(fileToOpen);
            fileOutput.println(fileContents);


            String text = FileManager.stringFromFile(fileToOpen);
            Assert.assertEquals(fileContents, text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void replaceAnswers() {
        File equationsFile = new File("/Users/ivy/Desktop/TexTesting/testMe.tex");
        String output = FileManager.stringFromFile(equationsFile);
        ArrayList<String> returnedEquations = EquationParser.getEquations(output);


        ArrayList<String> correctAnswers = new ArrayList<>();
        correctAnswers.add("$3+3=6$");
        correctAnswers.add("$3+3=6$");
        correctAnswers.add("$3^2=9$");
        correctAnswers.add("This is a test sentence");
        correctAnswers.add("$3^2=9$");

       returnedEquations= EquationChecker.correctAllAnswers(returnedEquations);

        for (int i = 0; i < returnedEquations.size(); i++) {
            Assert.assertTrue(returnedEquations.get(i).equals(correctAnswers.get(i)));
        }

    }
    @Test
    public void isFunction(){
        Assert.assertTrue(EquationParser.isFunction("$1+1=2$"));
        Assert.assertTrue(EquationParser.isFunction("$1+2=3$"));
        Assert.assertFalse(EquationParser.isFunction("This is not a function"));

    }
    @Test
    public void afterEquals(){
        ArrayList<String> correctAnswers = new ArrayList<>();
        correctAnswers.add("$3+3=6$");
        correctAnswers.add("$3+3=6$");
        correctAnswers.add("$3^2=9$");
        Assert.assertEquals(BigDecimal.valueOf(6),EquationParser.afterEquals(correctAnswers.get(0)));
        Assert.assertEquals(BigDecimal.valueOf(6),EquationParser.afterEquals(correctAnswers.get(1)));
        Assert.assertEquals(BigDecimal.valueOf(9),EquationParser.afterEquals(correctAnswers.get(2)));

    }


}
