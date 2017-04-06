package entities;

import javafx.scene.layout.Pane;

/**
 *
 * @author Shepyke
 */
public class CardPane extends Pane{
    private int cardNumber;
    //0 - empty     1 - red     2 - green   3 - blue    4 - joker
    private int owner;

    public CardPane(int cardNumber, int owner) {
        this.cardNumber = cardNumber;
        this.owner = owner;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
    
    
}
