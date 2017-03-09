package controller;

import java.util.UUID;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import manager.LoginManager;

/** Controls the login screen */
public class LoginController {
  @FXML private TextField user;
  @FXML private PasswordField password;
  @FXML private Button loginButton;
  
  public void initialize() {}
  
  public void initManager(final LoginManager loginManager) {
    loginButton.setOnAction(e -> {      
        String sessionID = authorize();
        if (sessionID != null) {
          loginManager.authenticated(sessionID);
        }      
    });
  }

  /**
   * Check authorization credentials.
   * 
   * If accepted, return a sessionID for the authorized session
   * otherwise, return null.
   */   
  private String authorize() {
    return 
      "open".equals(user.getText()) && "sesame".equals(password.getText()) 
            ? generateSessionID() 
            : null;
  }
  
  private static String sessionID;

  private String generateSessionID() {
    sessionID = UUID.randomUUID().toString() ;
    return sessionID;
  }
}
