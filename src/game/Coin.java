package game;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import static sequence.Sequence.CARD_SIZE;

/**
 *
 * @author Shepyke
 */
public class Coin extends StackPane{
    private CoinType type;
    private double mouseX, mouseY;
    private double oldX, oldY;

    public Coin(CoinType type, int x, int y) {
        this.type = type;
        
        Ellipse bg = new Ellipse(CARD_SIZE * 0.3125, CARD_SIZE * 0.26);
        bg.setFill(Color.BLACK);

        bg.setStroke(Color.BLACK);
        bg.setStrokeWidth(CARD_SIZE * 0.03);

        bg.setTranslateX((CARD_SIZE - CARD_SIZE * 0.3125 * 2) / 2);
        bg.setTranslateY((CARD_SIZE - CARD_SIZE * 0.26 * 2) / 2 + CARD_SIZE * 0.07);

        Ellipse ellipse = new Ellipse(CARD_SIZE * 0.3125, CARD_SIZE * 0.26);
        ellipse.setFill(type == CoinType.RED
                ? Color.valueOf("#C40003") : type == CoinType.GREEN ? Color.valueOf("#006400") : Color.valueOf("#00008B"));

        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(CARD_SIZE * 0.03);

        ellipse.setTranslateX((CARD_SIZE - CARD_SIZE * 0.3125 * 2) / 2);
        ellipse.setTranslateY((CARD_SIZE - CARD_SIZE * 0.26 * 2) / 2);

        getChildren().addAll(bg, ellipse);
    }
    
    
}
