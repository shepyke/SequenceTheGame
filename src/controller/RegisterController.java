package controller;

import db.SqliteConnection;
import java.util.UUID;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import manager.MainManager;

/**
 * Controls the login screen
 */
public class RegisterController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField age;
    @FXML
    private TextField gender;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField passwordRe;
    @FXML
    private Button signUpButton;
    @FXML
    private Button goBackButton;

    private static String sessionID;
    private static SqliteConnection connection;

    public void initialize() {
    }

    public void initManager(MainManager mainManager) {
        connection = new SqliteConnection();

        signUpButton.setOnAction(e -> {
            if (signUp()) {
                sessionID = authorize();
                if (sessionID != null) {
                    mainManager.authenticated(sessionID);
                }
            }
        });
        goBackButton.setOnAction(e -> {
            mainManager.showMain();
        });
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

    private boolean signUp() {
        boolean result = connection.addNewUser(firstName.getText(), lastName.getText(), gender.getText(),
                            age.getText(), userName.getText(), password.getText(), passwordRe.getText());
        if (result) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful");
            alert.setHeaderText("You have successfully signed up.");
            alert.showAndWait();
        }
        return result;
    }

    private String generateSessionID() {
        sessionID = UUID.randomUUID().toString();
        return sessionID;
    }
}
