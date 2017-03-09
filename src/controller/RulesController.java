package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import manager.MainManager;

/**
 *
 * @author Shepyke
 */
public class RulesController {
    @FXML
    Button goBackButton;
    
    public void initialize() {}
    
    public void initRules(final MainManager mainManager) {
        goBackButton.setOnAction(e -> {
            mainManager.showMain();
        });
    }
}
