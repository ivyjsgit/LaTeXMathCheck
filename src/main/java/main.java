import java.util.ArrayList;

public class main {
    public static void main(String[] args){
        String equation="$1+1=2$";
        ArrayList<String> foundEquations = EquationParser.getEquations(equation);
        for(String equationItem:foundEquations) {
            System.out.println(EquationChecker.checkEquation(equationItem));
        }
    }
}
