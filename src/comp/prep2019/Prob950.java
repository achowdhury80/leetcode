package comp.prep2019;
import java.util.*;
public class Prob950 {
	public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        if (deck.length < 3) return deck;
        List<Integer> result = new ArrayList<>();
        result.add(deck[deck.length - 2]);
        result.add(deck[deck.length - 1]);
        for (int i = deck.length - 3; i > -1; i--) {
        	result.add(0, result.remove(result.size() - 1));
        	result.add(0, deck[i]);
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
        	arr[i] = result.get(i);
        }
        return arr;
    }
}
