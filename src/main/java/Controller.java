import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    FileChooser fileChooser = new FileChooser();
    File selectedFile = new File("");
    ArrayList<String> correctedEquations = new ArrayList<>();
    ArrayList<String> parsedEquations = new ArrayList<>();
    @FXML
    GridPane parentGridPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("LaTeX Documents", "*.tex")
        );
    }

    @FXML
    public void openFilePicker(ActionEvent event) {

        fileChooser.setTitle("Open LaTeX File");


        File selectedFile = fileChooser.showOpenDialog(new Stage());

        String output = FileManager.stringFromFile(selectedFile);

       parsedEquations = EquationParser.getEquations(output);
       correctedEquations =EquationChecker.correctAllAnswers(parsedEquations);

        System.out.println(parsedEquations.toString());
        for(String equation: parsedEquations) {
            System.out.println(equation);
            JavaFXUtils.addMathRow(parentGridPane, equation,parsedEquations,correctedEquations);
        }
    }


    @FXML
    public void saveAsPushed(ActionEvent event) {
        fileChooser.setTitle("Save as");
        String stringOutput="";
        for(String line: parsedEquations){

          stringOutput+=line+"\n";
        }
        stringOutput= StringUtils.substringBeforeLast(stringOutput,"\n");
        File selectedFile = fileChooser.showSaveDialog(new Stage());
        FileManager.fileSaver(stringOutput,selectedFile.getAbsolutePath().toString());

    }
    @FXML
    public void quit(ActionEvent event){
        Platform.exit();
        System.exit(0);
    }

}
