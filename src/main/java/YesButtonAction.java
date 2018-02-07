import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class YesButtonAction implements EventHandler {
    private String equation;
    private ArrayList<String> equationsArray;
    private ArrayList<String> correctEquationsArray;
    private GridPane parentGrid;
    private int rowIndex;
    public YesButtonAction(String equation, ArrayList<String> equationsArray, ArrayList<String> correctEquationsArray, GridPane parentGrid, int rowIndex) {
        this.equation = equation;
        this.equationsArray = equationsArray;
        this.correctEquationsArray = correctEquationsArray;
        this.parentGrid=parentGrid;
        this.rowIndex = rowIndex;

    }


    @Override
    public void handle(Event event) {
        System.out.println(equationsArray);
        System.out.println(equation);
        System.out.println(equationsArray.indexOf(equation));
        this.equationsArray.set(equationsArray.indexOf(equation), correctEquationsArray.get(equationsArray.indexOf(equation)));
        System.out.println(this.equationsArray);
        parentGrid.getChildren().removeIf(node -> (GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) != 0) && GridPane.getRowIndex(node) == rowIndex);

    }

    public ArrayList<String> getEquationsArray() {
        return equationsArray;
    }
}
