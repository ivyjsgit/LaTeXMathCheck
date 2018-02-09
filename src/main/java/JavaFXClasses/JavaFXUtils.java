package JavaFXClasses;

import EquationParsing.EquationChecker;
import EquationParsing.EquationParser;
import com.apple.eawt.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;

class JavaFXUtils {
    public static int getRowNumber(GridPane gridPane) {
        return gridPane.getRowCount();
    }

    public static void addMathRow(GridPane parentGridPane, String equation, ArrayList<String> equationsArray, ArrayList<String> correctEquationsArray) {
        if (EquationChecker.isEquationFalse(equation) && EquationParser.isFunction(equation)) {

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
    public static void addLabelRow(GridPane parentGrid){
        parentGrid.add(new Text("Math expression"),0, 0);
        parentGrid.add(new Text("Result found"),1, 0);
        parentGrid.add(new Text("Calculated result"),2, 0);
        parentGrid.add(new Text("Accept changes"),3, 0);

    }
}

