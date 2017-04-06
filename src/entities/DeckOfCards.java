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

    public DeckOfCards(){
        store52Numbers();
        shuffleCards();
    }

    public int getNext(){
        int size = deckList.size()-1 >= 0 ? deckList.size()-1 : -1;
        if (size >= 0){
            int topCard = deckList.get(size);
            deckList.remove(size);
            return topCard;
        }
        return -1;
    }
    
    public int[] chooseFive() {
        Random rand = new Random();
        int num;
        int index = 0;

        for (int i = 52; i > 47; --i) {
            num = rand.nextInt(i);
            fiveCards[index] = deckList.get(num);
            deckList.remove(num);
            index++;
        }
        return fiveCards;
    }

    private void store52Numbers() {
        for (int i = 0; i < 52; ++i) {
            deckList.add(i + 1);
        }
    }
    
    private void shuffleCards(){
        Collections.shuffle(deckList);
    }
}
