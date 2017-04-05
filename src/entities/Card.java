package entities;

import javafx.scene.image.Image;

/**
 *
 * @author Shepyke
 */
public class Card {
    private String cardName;
    private int cardValue;
    private int cardNumber;
    private Image cardImage;

    public Card(String cardName, int cardValue, int cardNumber, Image cardImage) {
        this.cardName = cardName;
        this.cardValue = cardValue;
        this.cardNumber = cardNumber;
        this.cardImage = cardImage;
    }

    public Image getCardImage() {
        return cardImage;
    }

    public void setCardImage(Image cardImage) {
        this.cardImage = cardImage;
    }
    
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    
}
