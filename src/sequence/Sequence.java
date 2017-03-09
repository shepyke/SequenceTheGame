package sequence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Shepyke
 */
public class Sequence extends Application {
    private Stage window;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            window = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
            Scene sceneMain = new Scene(root);
            sceneMain.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
                      
            window.setTitle("Sequence Boardgame");
            window.setScene(sceneMain);
            window.show();             
            
        }catch (Exception e){
            e.printStackTrace();
        }        
    }
    
    public void setScene(Scene scene){
        window.setScene(scene);
    }   
}
