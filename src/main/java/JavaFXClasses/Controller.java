package JavaFXClasses;

import EquationParsing.EquationChecker;
import EquationParsing.EquationParser;
import EquationParsing.FileManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
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
    @FXML
    MenuItem openMenuItem;
    @FXML
    MenuItem saveAsButton;
    @FXML
    MenuItem quitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        JavaFXUtils.setDockIcon();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("LaTeX Documents", "*.tex")
        );

        if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
            openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.META_DOWN));
            saveAsButton.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.META_DOWN));
            quitButton.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.META_DOWN));


        } else {
            openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
            saveAsButton.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
            quitButton.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN));

        }

    }

    @FXML
    public void openFilePicker(ActionEvent event) {

        fileChooser.setTitle("Open LaTeX File");


        File selectedFile = fileChooser.showOpenDialog(new Stage());

        String output = FileManager.stringFromFile(selectedFile);

        parsedEquations = EquationParser.getEquations(output);
        correctedEquations = EquationChecker.correctAllAnswers(parsedEquations);

        System.out.println(parsedEquations.toString());
        for (String equation : parsedEquations) {
            System.out.println(equation);
            JavaFXUtils.addMathRow(parentGridPane, equation, parsedEquations, correctedEquations);
        }
    }


    @FXML
    public void saveAsPushed(ActionEvent event) {
        fileChooser.setTitle("Save as");
        StringBuilder stringOutput = new StringBuilder();
        for (String line : parsedEquations) {

            stringOutput.append(line).append("\n");
        }
        stringOutput = new StringBuilder(StringUtils.substringBeforeLast(stringOutput.toString(), "\n"));
        File selectedFile = fileChooser.showSaveDialog(new Stage());
        FileManager.fileSaver(stringOutput.toString(), selectedFile.getAbsolutePath());

    }

    @FXML
    public void quit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

}
