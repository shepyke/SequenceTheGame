package sequence;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import manager.MainManager;

/** Main application class for the login demo application */
public class LoginDemoApplication extends Application {
  public static void main(String[] args) { launch(args); }
  
  @Override
  public void start(Stage stage) throws IOException {
    try{
        Scene scene = new Scene(new StackPane());
        MainManager mainManager = new MainManager(scene);
        mainManager.showMain();

        stage.setScene(scene);
        stage.show();
    }catch(Exception e){
        e.printStackTrace();
    }
    
   
  }
}