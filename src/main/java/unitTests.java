import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

public class unitTests {
    @Test
    public void testOpenFile() {
        String text = FileManager.openFile("/Users/ivy/Desktop/TexTesting/testMe.tex");
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
        String pathName = "/Users/ivy/Desktop/TexTesting/text.txt";
        FileManager.fileSaver(fileContents, pathName);
        Assert.assertEquals(fileContents, FileManager.openFile("/Users/ivy/Desktop/TexTesting/text.txt"));
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
        System.out.println("Before math" +returnedEquations.size());

       returnedEquations= EquationChecker.correctAllAnswers(returnedEquations);

        System.out.println("Returned answers size " +returnedEquations.size());

        System.out.println("Testing assert" + correctAnswers.toString() + " " + returnedEquations.toString());
        for (int i = 0; i < returnedEquations.size(); i++) {
            Assert.assertTrue(returnedEquations.get(i).equals(correctAnswers.get(i)));
        }

    }
    @Test
    public void isFunction(){
        Assert.assertTrue(EquationParser.isFunction("$1+1=2$"));
        Assert.assertTrue(EquationParser.isFunction("$1+2=3$"));
        Assert.assertFalse(EquationParser.isFunction("thisisnotafn"));

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
