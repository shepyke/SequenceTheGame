package controller;

import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import manager.LoginManager;

/**
 * Controls the login screen
 */
public class LoginController {

    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginButton;
    @FXML
    private Label userName;

    public void initialize() {
    }

    public void initManager(final LoginManager loginManager) {
        loginButton.setOnAction(e -> {
            String sessionID = authorize();
            if (sessionID != null) {
                System.out.println("cucclika");
                loginManager.authenticated(sessionID);
            }
        });
    }

    public boolean login(ActionEvent event) {
        //userName.setText(user.toString());
        return authorize() != null ? true : false;
    }

    /**
     * Check authorization credentials.
     *
     * If accepted, return a sessionID for the authorized session otherwise,
     * return null.
     */
    private String authorize() {
        System.out.println(password.getText());
        return "open".equals(user.getText()) && "sesame".equals(password.getText())
                ? generateSessionID()
                : null;
    }

    private static String sessionID;

    private String generateSessionID() {
        sessionID = UUID.randomUUID().toString();
        return sessionID;
    }
}
