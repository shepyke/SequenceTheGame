package db;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Shepyke
 */
public class Player {
    private final StringProperty userName;
    private final StringProperty win;
    private final StringProperty lose;
    private final StringProperty tie;
    private final StringProperty scores;
    private final StringProperty date;

    public Player(String userName, String win, String lose, String tie, String scores, String date) {
        this.userName = new SimpleStringProperty(userName);
        this.win = new SimpleStringProperty(win);
        this.lose = new SimpleStringProperty(lose);
        this.tie = new SimpleStringProperty(tie);
        this.scores = new SimpleStringProperty(scores);
        this.date = new SimpleStringProperty(date);
    }

    public String getUserName() {
        return userName.get();
    }

    public String getWin() {
        return win.get();
    }

    public String getLose() {
        return lose.get();
    }

    public String getTie() {
        return tie.get();
    }

    public String getScores() {
        return scores.get();
    }

    public String getDate() {
        return date.get();
    }
    
    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void setWin(String win) {
        this.win.set(win);
    }

    public void setLose(String lose) {
        this.lose.set(lose);
    }

    public void setTie(String tie) {
        this.tie.set(tie);
    }

    public void setScores(String scores) {
        this.scores.set(scores);
    }

    public void setDate(String date) {
        this.date.set(date);
    }
    
    public StringProperty getUserNameProperty() {
        return userName;
    }

    public StringProperty getWinProperty() {
        return win;
    }

    public StringProperty getLoseProperty() {
        return lose;
    }

    public StringProperty getTieProperty() {
        return tie;
    }

    public StringProperty getScoresProperty() {
        return scores;
    }

    public StringProperty getDateProperty() {
        return date;
    }
    
    
}
