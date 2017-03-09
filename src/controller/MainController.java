package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import manager.MainManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Shepyke
 */
public class MainController {
    @FXML
    private Button loginMainButton;

    public void initialize() {
    }

    public void initManager(final MainManager mainManager) {
        mainManager.showMain();
    }

    public void exit(ActionEvent event) throws InterruptedException {
        //exitLabel.setText("Goodbye");
        Thread.sleep(300);
        System.exit(0);
    }

    public void goToLogin(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Stage window = new Stage();

            //can not click out of this window
            window.initModality(Modality.APPLICATION_MODAL);

            window.setTitle("Login");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
            window.setScene(scene);
            window.showAndWait();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
