package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.sqlite.SQLiteException;

/**
 *
 * @author Shepyke
 */
public class SqliteConnection {

    private ResultSet result = null;
    private PreparedStatement preparedStatement;

    //TABLE VIEW AND DATA
    private ObservableList<Player> data;
    private TableView<Player> tableview;

    private static Connection connection;

    /**
     * Connect to a sample database
     */
    public SqliteConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            // db parameters
            String url = "jdbc:sqlite:C:/Users/Shepyke/Desktop/szakdoga/Sequence_P/src/db/SequenceDB.sqlite";
            // create a connection to the database
            connection = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println("Connection to SQLite has not been established due to SQLException.");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Connection to SQLite has not been established due to other Exception.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            //try {
            if (connection != null) {
                //connection.close();
                System.out.println("siker de ne zárd le");
            }
            /*} catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }*/
        }
    }

    public boolean addNewUser(String firstName, String lastName, String gender, String age, String userName, String password, String passwordRe) {
        try {
            if (password.equals(passwordRe)) {
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO Players(firstName, lastName, Gender, Age, Username, password)"
                        + "VALUES (?,?,?,?,?,?)");
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, gender);
                preparedStatement.setString(4, age);
                preparedStatement.setString(5, userName);
                preparedStatement.setString(6, password);

                preparedStatement.executeUpdate();
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Your password and re-password is different. Please try again.");
                alert.showAndWait();
                return false;
            }
        } catch (SQLiteException ex) {
            if (ex.getMessage().contains("SQLITE_CONSTRAINT_UNIQUE")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(userName + " username is already in use. Please try it again with another username.");
                alert.showAndWait();
            } else {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean getUserToLogin(String userName, String password) {
        String sql = "SELECT userName "
                + "FROM Players "
                + "WHERE Username = ? AND "
                + "Password = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            result = preparedStatement.executeQuery();
            if (!result.next()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Unsuccessful");
                alert.setHeaderText("Incorrect username or password. Please try it again.");
                alert.showAndWait();
                return false;
            } else {
                /* Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Successful");
                alert.setHeaderText("You have successfully logged in.");                

                alert.showAndWait();*/
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   /* public TableView<Player> getDataForHistory(TableColumn<Player, String> columnUserName,
            TableColumn<Player, String> columnWin,
            TableColumn<Player, String> columnLose,
            TableColumn<Player, String> columnTie,
            TableColumn<Player, String> columnScores,
            TableColumn<Player, String> columnDate) {
        data = FXCollections.observableArrayList();
        try {
            String SQL = "SELECT * from Result";
            ResultSet rs = connection.createStatement().executeQuery(SQL);
            while (rs.next()) {
                data.add(new Player(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
            
            columnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
            columnWin.setCellValueFactory(new PropertyValueFactory<>("win"));
            columnLose.setCellValueFactory(new PropertyValueFactory<>("lose"));
            columnTie.setCellValueFactory(new PropertyValueFactory<>("tie"));
            columnScores.setCellValueFactory(new PropertyValueFactory<>("scores"));
            columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            tableview.setItems(data);
            
            return tableview;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
            return null;
        }
    }*/
}
