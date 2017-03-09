package sequence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import manager.MainManager;

/**
 *
 * @author Shepyke
 */
public class Sequence extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            Scene scene = new Scene(new StackPane());
            MainManager mainManager = new MainManager(scene);
            mainManager.showMain();
             
            primaryStage.setScene(scene);
            primaryStage.show();             
        }catch (Exception e){
            e.printStackTrace();
        }  
    }
}
