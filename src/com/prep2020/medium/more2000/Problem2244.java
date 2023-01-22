package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2244 {
	public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tasks) map.put(t, map.getOrDefault(t, 0) + 1);
        int result = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        	if (e.getValue() == 1) return -1;
        	result += e.getValue() / 3;
        	if (e.getValue() % 3 != 0) result++;
        }
        return result;
    }
}
