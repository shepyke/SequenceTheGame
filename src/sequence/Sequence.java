package sequence;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import manager.MainManager;

/**
 *
 * @author Shepyke
 */
public class Sequence extends Application {
    public static final int CARD_SIZE = 100;
    
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
            primaryStage.setFullScreen(true);
            primaryStage.show();             
        }catch (Exception e){
            e.printStackTrace();
        }  
    }
}
