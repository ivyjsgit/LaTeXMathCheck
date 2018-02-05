import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

public class JavaFXUtils {
    //Taken from https://stackoverflow.com/a/39807235
    //Code by Vova Perebykivskyi on StackOverflow
    public static int getRowNumber(GridPane gridPane) {

        Integer rows=0;
        try {
            Method method = gridPane.getClass().getDeclaredMethod("getNumberOfRows");
            method.setAccessible(true);
             rows = (Integer) method.invoke(gridPane);
        } catch (Exception e) {

        }
    return (int)rows;
    }
    public static void addMathRow(GridPane parentGridPane, String equation, ArrayList<String> equationsArray, ArrayList<String> correctEquationsArray){
        if(!EquationChecker.isEquationTrue(equation)&&EquationParser.isFunction(equation)) {

            String displayText = EquationParser.beforeEquals(equation) + "=" + EquationParser.afterEquals(equation);
            BigDecimal returnedAnswer = EquationChecker.getCalculatedAnswer(EquationParser.beforeEquals(equation));
            System.out.println(returnedAnswer.toString());

            int numberOfRows = JavaFXUtils.getRowNumber(parentGridPane);

            Text expressionText = new Text(displayText);
            expressionText.setText(displayText);
            Text foundResult = new Text(EquationChecker.getSuppliedAnswer(equation).toString());
            Text calculatedResult = new Text(EquationChecker.getCalculatedAnswer(equation).toString());
            GridPane yesNoBox = new GridPane();
            Button yesButton = new Button("Yes");
            yesButton.setAlignment(Pos.CENTER);
            YesButtonAction yesButtonAction = new YesButtonAction(equation, equationsArray,correctEquationsArray);
            yesButton.setOnAction(evt -> yesButtonAction.handle(evt));

            Button noButton = new Button("No");
            noButton.setAlignment(Pos.CENTER);
            yesNoBox.setAlignment(Pos.CENTER);

            yesNoBox.add(yesButton, 0, 0);
            yesNoBox.add(noButton, 1, 0);

            parentGridPane.add(expressionText, 0, numberOfRows + 1);
            parentGridPane.add(foundResult, 1, numberOfRows + 1);
            parentGridPane.add(calculatedResult, 2, numberOfRows + 1);
            parentGridPane.add(yesNoBox, 3, numberOfRows + 1);

        }
    }
}

