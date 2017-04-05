package controller;

import javafx.scene.control.Button;
import manager.MainManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author Shepyke
 */
public class MainController {

    @FXML
    private Label userName;
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button startButton;
    @FXML
    private Button rulesButton;
    @FXML
    private Button historyButton;
    @FXML
    private Button exitButton;

    public void initialize() {
    }

    public void initManager(final MainManager mainManager) {
        loginButton.setOnAction(e -> {
            mainManager.showLogin();
        });
        
        signUpButton.setOnAction(e -> {
            mainManager.showRegister();
        });
        
        startButton.setOnAction(e -> {
            mainManager.showGame();
        });

        rulesButton.setOnAction(e -> {
            mainManager.showRules();
        });

        historyButton.setOnAction(e -> {
            mainManager.showHistory();
        });

        exitButton.setOnAction(e -> {
            System.exit(0);
        });
    }

    public void initSessionID(final MainManager mainManager, String sessionID) {
        userName.setText(sessionID);

        logoutButton.setOnAction(e -> {
            mainManager.logout();
        });
        rulesButton.setOnAction(e -> {
            mainManager.showRules();
        });

        historyButton.setOnAction(e -> {
            mainManager.showHistory();
        });

        exitButton.setOnAction(e -> {
            System.exit(0);
        });
    }
}
