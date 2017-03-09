package manager;

import controller.HistoryController;
import controller.MainController;
import controller.RulesController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author Shepyke
 */
public class MainManager {
    private Scene scene;

    public MainManager(Scene scene) {
        this.scene = scene;
    }

    public void showMain(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
            scene.setRoot((Parent) loader.load());
            MainController controller = loader.<MainController>getController();
            controller.initManager(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void showGame(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Main.fxml"));
            scene.setRoot((Parent) loader.load());
            MainController controller = loader.<MainController>getController();
            controller.initManager(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void showRules(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Rules.fxml"));
            scene.setRoot((Parent) loader.load());
            RulesController controller = loader.<RulesController>getController();
            controller.initRules(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void showHistory(){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/History.fxml"));
            scene.setRoot((Parent) loader.load());
            HistoryController controller = loader.<HistoryController>getController();
            controller.initHistory(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
