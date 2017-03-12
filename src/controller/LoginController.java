package controller;

import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import manager.MainManager;

/**
 * Controls the login screen
 */
public class LoginController {
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Label userName;
    @FXML
    private Button loginButton;
    @FXML
    private Button goBackButton;
    
    private static String sessionID;

    public void initialize() {
    }

    public void initManager(MainManager mainManager) {
        loginButton.setOnAction(e -> {
            String sessionID = authorize();
            if (sessionID != null) {
                mainManager.authenticated(sessionID);
            }
        });
        goBackButton.setOnAction(e -> {
            mainManager.showMain();
        });
    }    

    public boolean login(ActionEvent event) {
        return authorize() != null ? true : false;
    }

    /**
     * Check authorization credentials.
     *
     * If accepted, return a sessionID for the authorized session otherwise,
     * return null.
     */
    private String authorize() {
        return "open".equals(user.getText()) && "sesame".equals(password.getText())
                ? generateSessionID()
                : null;
    }

    private String generateSessionID() {
        sessionID = UUID.randomUUID().toString();
        return sessionID;
    }
}
