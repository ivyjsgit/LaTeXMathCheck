import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class YesButtonAction implements EventHandler {
    private String equation;
    private ArrayList<String> equationsArray;
    private ArrayList<String> correctEquationsArray;

    public YesButtonAction(String equation, ArrayList<String> equationsArray, ArrayList<String> correctEquationsArray) {
        this.equation = equation;
        this.equationsArray = equationsArray;
        this.correctEquationsArray = correctEquationsArray;
    }


    @Override
    public void handle(Event event) {
        System.out.println(equationsArray);
        System.out.println(equation);
        System.out.println(equationsArray.indexOf(equation));
        this.equationsArray.set(equationsArray.indexOf(equation), correctEquationsArray.get(equationsArray.indexOf(equation)));
        System.out.println(this.equationsArray);
    }

    public ArrayList<String> getEquationsArray() {
        return equationsArray;
    }
}
