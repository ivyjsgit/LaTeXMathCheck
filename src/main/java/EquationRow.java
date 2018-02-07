import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.util.ArrayList;

public class EquationRow {
    int rowIndex;
    private GridPane parentGridPane;
    private String equation;
    private ArrayList<String> equationsArray;
    private ArrayList<String> correctEquationsArray;
    private Text expressionText;
    private Text foundResult;
    private Text calculatedResult;
    private GridPane yesNoBox;


    public EquationRow(GridPane parentGridPane, String equation, ArrayList<String> equationsArray, ArrayList<String> correctEquationsArray) {
        if (!EquationChecker.isEquationTrue(equation) && EquationParser.isFunction(equation)) {

            String displayText = EquationParser.beforeEquals(equation) + "=" + EquationParser.afterEquals(equation);
            BigDecimal returnedAnswer = EquationChecker.getCalculatedAnswer(EquationParser.beforeEquals(equation));
            System.out.println(returnedAnswer.toString());

            int numberOfRows = JavaFXUtils.getRowNumber(parentGridPane);

            rowIndex = numberOfRows + 1;

            expressionText = new Text(displayText);
            expressionText.setText(displayText);
            setFoundResult(new Text(EquationChecker.getSuppliedAnswer(equation).toString()));
            setCalculatedResult(new Text(EquationChecker.getCalculatedAnswer(equation).toString()));
            setYesNoBox(new GridPane());
            Button yesButton = new Button("Yes");
            yesButton.setAlignment(Pos.CENTER);
            YesButtonAction yesButtonAction = new YesButtonAction(equation, equationsArray, correctEquationsArray, parentGridPane, rowIndex);
            yesButton.setOnAction(evt -> yesButtonAction.handle(evt));

            Button noButton = new Button("No");
            NoButtonAction noButtonAction = new NoButtonAction(parentGridPane, rowIndex, displayText);
            noButton.setOnAction(evt -> noButtonAction.handle(evt));

            noButton.setAlignment(Pos.CENTER);
            getYesNoBox().setAlignment(Pos.CENTER);

            getYesNoBox().add(yesButton, 0, 0);
            getYesNoBox().add(noButton, 1, 0);

        }
    }

    public Text getFoundResult() {
        return foundResult;
    }

    public void setFoundResult(Text foundResult) {
        this.foundResult = foundResult;
    }

    public Text getCalculatedResult() {
        return calculatedResult;
    }

    public void setCalculatedResult(Text calculatedResult) {
        this.calculatedResult = calculatedResult;
    }

    public GridPane getYesNoBox() {
        return yesNoBox;
    }

    public void setYesNoBox(GridPane yesNoBox) {
        this.yesNoBox = yesNoBox;
    }

    public GridPane getParentGridPane() {
        return parentGridPane;
    }

    public String getEquation() {
        return equation;
    }


    public ArrayList<String> getEquationsArray() {
        return equationsArray;
    }

    public ArrayList<String> getCorrectEquationsArray() {
        return correctEquationsArray;
    }

    public Text getExpressionText() {
        return expressionText;
    }

    public int getRowIndex() {
        return rowIndex;
    }

}
