package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2225 {
	public List<List<Integer>> findWinners(int[][] matches) {
		Map<Integer, Integer> loses = new HashMap<>();
		for (int[] m : matches) {
			loses.put(m[0], loses.getOrDefault(m[0], 0));
			loses.put(m[1], loses.getOrDefault(m[1], 0) + 1);
		}
		List<Integer> noLoses = new ArrayList<>(), oneLoss = new ArrayList<>();
		for (Map.Entry<Integer, Integer> e : loses.entrySet()) {
			if (e.getValue() == 0) noLoses.add(e.getKey());
			else if (e.getValue() == 1) oneLoss.add(e.getKey());
		}
		Collections.sort(noLoses);
		Collections.sort(oneLoss);
		return Arrays.asList(noLoses, oneLoss);
    }
}
