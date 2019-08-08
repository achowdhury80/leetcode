package com.leet.algo;

import java.util.*;

public class Prob950 {
	public int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);
        if (deck.length < 3) return deck;
        List<Integer> list = new ArrayList<>();
        list.add(deck[deck.length - 2]);
        list.add(deck[deck.length - 1]);
        for (int i = deck.length - 3; i > -1; i--) {
        	list.add(0, list.remove(list.size() - 1));
        	list.add(0, deck[i]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
