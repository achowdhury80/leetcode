package com.prep2020.easy;
import java.util.*;
public class Problem2347 {
	public String bestHand(int[] ranks, char[] suits) {
        if (suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4]) return "Flush";
        Map<Integer, Integer> map = new HashMap<>();
        String result = "High Card";
        for (int r : ranks) {
        	map.put(r, map.getOrDefault(r, 0) + 1);
        	if (map.get(r) == 3) return "Three of a Kind";
        	if (map.get(r) == 2) result = "Pair";
        }
        return result;
    }
}
