package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2260 {
	public int minimumCardPickup(int[] cards) {
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
        	if (map.containsKey(cards[i])) result = Math.min(result, i - map.get(cards[i]) + 1);
        	map.put(cards[i], i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
