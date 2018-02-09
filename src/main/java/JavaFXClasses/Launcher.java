package JavaFXClasses;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    private static Scene scene;
    private static Stage returnableStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root;
        returnableStage=primaryStage;
        try {
            root = FXMLLoader.load(getClass().getResource("/MathSolver.fxml"));
            scene = new Scene(root, 1080, 1920);
            primaryStage.setTitle("MathSolver");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Stage getPrimaryStage(){
        return returnableStage;
    }
}
