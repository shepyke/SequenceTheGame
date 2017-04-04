package controller;

import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import manager.MainManager;
import db.SqliteConnection;

/**
 * Controls the login screen
 */
public class LoginController {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button goBackButton;
    
    private static String sessionID;
    private static SqliteConnection connection;

    public void initialize() {
    }

    public void initManager(MainManager mainManager) {
        connection = new SqliteConnection();
                
        loginButton.setOnAction(e -> {
            sessionID = authorize();
            if (sessionID != null) {
                mainManager.authenticated(sessionID);
            }
        });
        goBackButton.setOnAction(e -> {
            mainManager.showMain();
        });
    }    

    public boolean login(ActionEvent event) {
        return authorize() != null;
    }

    /**
     * Check authorization credentials.
     *
     * If accepted, return a sessionID for the authorized session otherwise,
     * return null.
     */
    private String authorize() {  
        return connection.getUserToLogin(userName.getText(), password.getText())
                ? generateSessionID()
                : null;
    }

    private String generateSessionID() {
        sessionID = userName.getText() + "-" + UUID.randomUUID().toString();
        return sessionID;
    }
}
