package JavaFXClasses;

import EquationParsing.EquationChecker;
import EquationParsing.EquationParser;
import JavaFXClasses.EquationRow;
import com.apple.eawt.Application;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class JavaFXUtils {
    //Taken from https://stackoverflow.com/a/39807235
    //Code by Vova Perebykivskyi on StackOverflow
    public static int getRowNumber(GridPane gridPane) {

        Integer rows = 0;
        try {
            Method method = gridPane.getClass().getDeclaredMethod("getNumberOfRows");
            method.setAccessible(true);
            rows = (Integer) method.invoke(gridPane);
        } catch (Exception e) {

        }
        return (int) rows;
    }

    public static void addMathRow(GridPane parentGridPane, String equation, ArrayList<String> equationsArray, ArrayList<String> correctEquationsArray) {
        if (!EquationChecker.isEquationTrue(equation) && EquationParser.isFunction(equation)) {


            EquationRow equationRow = new EquationRow(parentGridPane, equation, equationsArray, correctEquationsArray);


            parentGridPane.add(equationRow.getExpressionText(), 0, equationRow.getRowIndex());
            parentGridPane.add(equationRow.getFoundResult(), 1, equationRow.getRowIndex());
            parentGridPane.add(equationRow.getCalculatedResult(), 2, equationRow.getRowIndex());
            parentGridPane.add(equationRow.getYesNoBox(), 3, equationRow.getRowIndex());

        }
    }

    public static void setDockIcon() {
        Application application = Application.getApplication();
        Image image = Toolkit.getDefaultToolkit().getImage("src/main/resources/MathCheck.png");
        application.setDockIconImage(image);

    }
}

