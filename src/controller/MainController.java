package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Shepyke
 */
public class MainController{
    @FXML
    private Label exitLabel;
    
    @FXML
    private Button exitButton;
    
    @FXML
    private Button historyButton;
    
    @FXML
    private Button closeButton;
    
    @FXML
    private Button loginMainButton;    
    
    @FXML
    private Stage window;
    
    public void exit(ActionEvent event) throws InterruptedException{
         //exitLabel.setText("Goodbye");
         Thread.sleep(300);
         System.exit(0);
    }
    
    public void closeWindow(ActionEvent event){
        closeButton.setOnAction(e -> window.close());
    }
    
    public void goToRules(ActionEvent event){
        changeScene("Rules");
    }
    
    public void goToHistory(ActionEvent event){
        changeScene("History");
    }
    
    public void goToGame(ActionEvent event){
        changeScene("Game");
    }
    
    public void goToLogin(ActionEvent event){
        changeScene("Login");
    }
    
    private void changeScene(String title){                  
        Parent root;
        try {
            window = new Stage();

            //can not click out of this window
            window.initModality(Modality.APPLICATION_MODAL);
            
            window.setTitle(title);
            root = FXMLLoader.load(getClass().getResource("/view/" + title + ".fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());       
            window.setScene(scene);
            window.showAndWait();
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
      
    }
}
