package manager;

import controller.HistoryController;
import controller.LoginController;
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

    public void showMain() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainLoggedOut.fxml"));
            scene.setRoot((Parent) loader.load());
            MainController controller = loader.<MainController>getController();
            controller.initManager(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void showMainLoggedIn(String sessionID) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainLoggedIn.fxml"));
            scene.setRoot((Parent) loader.load());
            MainController controller = loader.<MainController>getController();
            controller.initSessionID(this, sessionID);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            scene.setRoot((Parent) loader.load());
            LoginController controller = loader.<LoginController>getController();
            controller.initManager(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /*
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
    */
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
    
    /**
     * Callback method invoked to notify that a user has been authenticated.
     * Will show the main application screen.
     */
    public void authenticated(String sessionID) {
        showMainLoggedIn(sessionID);
    }

    /**
     * Callback method invoked to notify that a user has logged out of the main
     * application. Will show the login application screen.
     */
    public void logout() {
        showMain();
    }
}
