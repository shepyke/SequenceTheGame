package controller;

import entities.DeckOfCards;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import manager.MainManager;
import view.ContextMenuItem;

/**
 * FXML Controller class
 *
 * @author Shepyke
 */
public class GameController {

    ContextMenuItem contextMenu = new ContextMenuItem();
    private final HashMap<Pane, Boolean> cardPaneList = new HashMap<Pane, Boolean>();
    private final DeckOfCards deck = new DeckOfCards();
    
    @FXML
    private Button goBackButton;
    @FXML
    private GridPane gridBoard;
    @FXML
    private GridPane gridUserName;
    @FXML
    private Label userName;
    @FXML
    private Pane paneDeck;
    @FXML
    private Pane card1;
    @FXML
    private Pane card2;
    @FXML
    private Pane card3;
    @FXML
    private Pane card4;
    @FXML
    private Pane card5;
    @FXML
    private Pane card53;
    @FXML
    private Pane card35;
    @FXML
    private Pane card34;
    @FXML
    private Pane card33;
    @FXML
    private Pane card32;
    @FXML
    private Pane card31;
    @FXML
    private Pane card30;
    @FXML
    private Pane card29;
    @FXML
    private Pane card28;
    @FXML
    private Pane card36;
    @FXML
    private Pane card23;
    @FXML
    private Pane card25;
    @FXML
    private Pane card26;
    @FXML
    private Pane card14;
    @FXML
    private Pane card6;
    @FXML
    private Pane card38;
    @FXML
    private Pane card22;
    @FXML
    private Pane card7;
    @FXML
    private Pane card39;
    @FXML
    private Pane card21;
    @FXML
    private Pane card55;
    @FXML
    private Pane card56;
    @FXML
    private Pane card57;
    @FXML
    private Pane card58;
    @FXML
    private Pane card59;
    @FXML
    private Pane card8;
    @FXML
    private Pane card27;
    @FXML
    private Pane card20;
    @FXML
    private Pane card67;
    @FXML
    private Pane card60;
    @FXML
    private Pane card9;
    @FXML
    private Pane card19;
    @FXML
    private Pane card68;
    @FXML
    private Pane card61;
    @FXML
    private Pane card10;
    @FXML
    private Pane card18;
    @FXML
    private Pane card62;
    @FXML
    private Pane card12;
    @FXML
    private Pane card17;
    @FXML
    private Pane card54;
    @FXML
    private Pane card66;
    @FXML
    private Pane card65;
    @FXML
    private Pane card63;
    @FXML
    private Pane card13;
    @FXML
    private Pane card16;
    @FXML
    private Pane card15;

    public void initialize() {
    }

    public void initManager(MainManager mainManager) {
        getFiveCard(deck);
        goBackButton.setOnAction(e -> {
            mainManager.showMain();
        });

        /*PerspectiveTransform e = new PerspectiveTransform();
        e.setUlx(100);     // Upper-left point
        e.setUly(150);
        e.setUrx(920);    // Upper-right point
        e.setUry(150);
        e.setLlx(70);      // Lower-left point
        e.setLly(500);
        e.setLrx(1020);    // Lower-right point
        e.setLry(500);
        gridBoard.setEffect(e);
        
        PerspectiveTransform f = new PerspectiveTransform();
        f.setUlx(30);     // Upper-left point
        f.setUly(150);
        f.setUrx(100);    // Upper-right point
        f.setUry(150);
        f.setLlx(0);      // Lower-left point
        f.setLly(350);
        f.setLrx(70);    // Lower-right point
        f.setLry(500);
        leftOpponent.setEffect(f);*/

    }

    @FXML
    private void showContextMenu(ContextMenuEvent event) {
        contextMenu.show((Pane) (event.getTarget()), event.getScreenX(), event.getScreenY());
    }

    @FXML
    private void getOneCard(MouseEvent event) {
        int cardNext = deck.getNext();
        if (cardNext > 0) {
            if (getNewCard() != null) {
                setCard(getNewCard(), cardNext);
            }
        } else {
            paneDeck.setVisible(false);
        }
    }

    private void setCard(Pane pane, int cardNum) {
        String imageStr = "/image/cardsUp/" + cardNum + ".png";
        Image image = new Image(imageStr, 100, 120, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));
    }

    private void getFiveCard(DeckOfCards deck) {
        int[] cards = deck.chooseFive();
        initCards();
        for (int i = 0; i < 5; ++i) {
            setCard(getNewCard(), cards[i]);
        }
    }

    private Pane getNewCard() {
        if (cardPaneList.get(card1)) {
            setCards(card1);
            return card1;
        }
        if (cardPaneList.get(card2)) {
            setCards(card2);
            return card2;
        }
        if (cardPaneList.get(card3)) {
            setCards(card3);
            return card3;
        }
        if (cardPaneList.get(card4)) {
            setCards(card4);
            return card4;
        }
        if (cardPaneList.get(card5)) {
            setCards(card5);
            return card5;
        }

        return null;
    }

    private void initCards() {
        cardPaneList.put(card1, true);
        cardPaneList.put(card2, true);
        cardPaneList.put(card3, true);
        cardPaneList.put(card4, true);
        cardPaneList.put(card5, true);
    }

    private void setCards(Pane card) {
        cardPaneList.put(card, false);
    }
}
