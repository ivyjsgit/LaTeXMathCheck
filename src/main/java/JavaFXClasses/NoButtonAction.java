package JavaFXClasses;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

public class NoButtonAction implements EventHandler {
    GridPane parentGrid;
    int rowIndex;
    private String equation;

    public NoButtonAction(GridPane parentGrid, int rowIndex, String equation) {
        this.parentGrid = parentGrid;
        this.rowIndex = rowIndex;
        this.equation = equation;
    }

    @Override
    public void handle(Event event) {
        //Adapted from https://stackoverflow.com/a/47685736
        //Ruben9922
        parentGrid.getChildren().removeIf(node -> (GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) != 0) && GridPane.getRowIndex(node) == rowIndex);
    }
}
