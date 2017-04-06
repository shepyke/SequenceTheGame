package view;

import controller.RulesController;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Shepyke
 */
public class ContextMenuItem extends ContextMenu {

    /**
     * The put menu.
     */
    MenuItem putCoin = new MenuItem("Put");

    /**
     * The remove menu.
     */
    MenuItem removeCoin = new MenuItem("Remove");

    /**
     * Constructor.
     */
    public ContextMenuItem() {
        putCoin.setOnAction(e -> {
            System.out.println(getOwnerNode());
            getOwnerNode().setDisable(true);
        });
        removeCoin.setOnAction(e -> {
            System.out.println(getOwnerNode());
            getOwnerNode().setDisable(false);

        });
        getItems().addAll(putCoin, removeCoin);
    }
}
