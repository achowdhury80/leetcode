package com.prep2020.medium;
import java.util.*;
import java.util.Map.Entry;
public class Problem1366 {
	/**
	 * O(m * N) + O(NlogN)
	 * @param votes
	 * @return
	 */
	public String rankTeams(String[] votes) {
        int n = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();
        for (String vote : votes) {
        	for (int i = 0; i < n; i++) {
        		char c = vote.charAt(i);
        		if (!map.containsKey(c)) map.put(c, new int[n]);
        		int[] arr = map.get(c);
        		arr[i]++;
        	}
        }
        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (x, y) -> compareEntries(x, y));
        String result = "";
        for (Map.Entry<Character, int[]> entry : list) result += entry.getKey();
        return result;
    }

	private int compareEntries(Entry<Character, int[]> x, Entry<Character, int[]> y) {
		int[] arr1 = x.getValue(), arr2 = y.getValue();
		int n = arr1.length;
		for (int i = 0; i < n; i++) {
			if (arr1[i] != arr2[i]) return arr2[i] - arr1[i];
		}
		return x.getKey().compareTo(y.getKey());
	}
}
