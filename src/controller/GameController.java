package controller;

import db.SqliteConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import manager.MainManager;

/**
 * FXML Controller class
 *
 * @author Shepyke
 */
public class GameController{
    @FXML
    private Button goBackButton;
    
    public void initialize() {
        
    }    
    
    public void initManager(MainManager mainManager) {
        goBackButton.setOnAction(e -> {
            mainManager.showMain();
        });
    }
    
}
