import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    FileChooser fileChooser = new FileChooser();
    File selectedFile = new File("");
    ArrayList<String> equations= new ArrayList<>();
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

       equations = EquationParser.getEquations(output);
       equations=EquationChecker.correctAllAnswers(equations);
    }


    @FXML
    public void saveAsPushed(ActionEvent event) {
        fileChooser.setTitle("Open Resource File");
        String stringOutput="";
        for(String line:equations){

          stringOutput+="$"+line+"$\n";
        }
        stringOutput= StringUtils.substringBeforeLast(stringOutput,"\n");
        File selectedFile = fileChooser.showSaveDialog(new Stage());
        try {
            selectedFile.createNewFile();
            PrintStream fileOutput = new PrintStream(selectedFile);

            fileOutput = new PrintStream(selectedFile);
            fileOutput.println(stringOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
