package JavaFXClasses;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;

class NoButtonAction implements EventHandler {
    private GridPane parentGrid;
    private int rowIndex;

    public NoButtonAction(GridPane parentGrid, int rowIndex) {
        this.parentGrid = parentGrid;
        this.rowIndex = rowIndex;
    }

    @Override
    public void handle(Event event) {
        //Adapted from https://stackoverflow.com/a/47685736
        //Ruben9922
        parentGrid.getChildren().removeIf(node -> (GridPane.getRowIndex(node) != null && GridPane.getRowIndex(node) != 0) && GridPane.getRowIndex(node) == rowIndex);
    }
}
