import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class unitTests {
    @Test
    public void testEquations(){
        System.out.println("Running tests");
        String trueEquations = "$1+1=2$ $2+2=4$ $1.5+1.5=3$";
        String falseEquations = "$1+1=3$ $2+2=100$";

        ArrayList<String> parsedTrueEquations = EquationParser.getEquations(trueEquations);
        ArrayList<String> parsedFalseEquations = EquationParser.getEquations(falseEquations);

        for(String equation:parsedTrueEquations){
            Assert.assertTrue(EquationChecker.checkEquation(equation));
        }
        for(String equation:parsedFalseEquations){
            Assert.assertFalse(EquationChecker.checkEquation(equation));
        }
    }

    @Test
    public void testFiles(){
        String text = FileOpener.openFile("/Users/ivy/Desktop/TexTesting/testMe.tex");
        Assert.assertEquals("$3+3=6$",text);
    }

}
