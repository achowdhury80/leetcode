package com.prep2020.medium;

import java.util.*;

public class Problem950 {
	/**
	 * O(NlogN) time and O(N) space
	 * @param deck
	 * @return
	 */
	public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        if (n < 3) return deck;
        List<Integer> list = new ArrayList<>();
        list.add(deck[n - 2]);
        list.add(deck[n - 1]);
        for (int i = n - 3; i > -1; i--) {
        	list.add(0, list.remove(list.size() - 1));
        	list.add(0, deck[i]);
        }
        for (int i = 0; i < n; i++) deck[i] = list.get(i);
        return deck;
    }
}
