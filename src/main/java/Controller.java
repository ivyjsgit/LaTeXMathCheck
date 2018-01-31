import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void openFilePicker(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
   File selectedFile=     fileChooser.showOpenDialog(new Stage());

       String output= FileOpener.openFile(selectedFile.getAbsolutePath());
        System.out.println(output);

      ArrayList<String> returnedEquations= EquationParser.getEquations(output);
      for(String equation: returnedEquations){
          System.out.println(EquationChecker.checkEquation(equation));
      }

    }
}