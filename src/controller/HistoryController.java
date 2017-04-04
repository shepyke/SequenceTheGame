package controller;

import db.Player;
import db.SqliteConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.MainManager;

/**
 *
 * @author Shepyke
 */
public class HistoryController {
    @FXML
    private Button goBackButton;
    @FXML
    private TableView<Player> overallTable;
    
    @FXML
    private TableColumn<Player, String> columnPos;
    @FXML
    private TableColumn<Player, String> columnUserName;
    @FXML
    private TableColumn<Player, String> columnWin;
    @FXML
    private TableColumn<Player, String> columnLose;
    @FXML
    private TableColumn<Player, String> columnTie;
    @FXML
    private TableColumn<Player, String> columnScores;
    @FXML
    private TableColumn<Player, String> columnDate;
    
    private static SqliteConnection connection;
    private ObservableList<Player> data;
    
    public void initialize() {}
    
    public void initHistory(final MainManager mainManager) {
        connection = new SqliteConnection();
        //getHistoryDataFromDb(columnUserName, columnWin, columnLose, columnTie, columnScores, columnDate);
        goBackButton.setOnAction(e -> {
            mainManager.showMain();
        });
    }
    
    public void getHistoryDataFromDb(TableColumn<Player, String> columnUserName,
            TableColumn<Player, String> columnWin,
            TableColumn<Player, String> columnLose,
            TableColumn<Player, String> columnTie,
            TableColumn<Player, String> columnScores,
            TableColumn<Player, String> columnDate){
        //overallTable = connection.getDataForHistory(columnUserName, columnWin, columnLose, columnTie, columnScores, columnDate);
    }   
}
