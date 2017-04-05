package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Shepyke
 */
public class DeckOfCards {
    private ArrayList<Integer> deckList = new ArrayList<>();
    int[] fiveCards = new int[5];

    public void chooseFive(int[] fiveCards) {
        Random rand = new Random();
        int num;
        int index = 0;

        for (int i = 52; i > 47; --i) {
            num = rand.nextInt(i);
            fiveCards[index] = deckList.get(num);
            deckList.remove(num);
            index++;
        }
    }

    public void store52Numbers() {
        for (int i = 0; i < 52; ++i) {
            deckList.add(i + 1);
        }
    }
    
    public void displayNum(int[] fiveCards){
        for(int i=0; i < fiveCards.length; ++i){
            System.out.println(fiveCards[i]);
        }
    }
    
    public void shuffleCards(){
        Collections.shuffle(deckList);
    }
}
