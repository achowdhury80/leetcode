package com.prep2020.hard;
import java.util.*;

public class Problem1307 {
	public boolean isSolvable(String[] words, String result) {
        int n = result.length();
        for (String w : words) if (w.length() > n) return false;
        return helper(words, result, 0, 0, new HashMap<>(), 0);
    }
	
	private boolean helper(String[] words, String result, int startPos, int startWord, Map<Character, Integer> map, int carry) {
		int n = result.length();
		if (startPos == n) return true;
		int sum = carry;
		for (int i = startWord; i < words.length; i++) {
			String w = words[startWord];
			if (startPos >= w.length()) continue;
			char c = w.charAt(w.length() - 1 - startPos);
			if (map.containsKey(c)) {
				sum += map.get(c);
				continue;
			}
			for (int j = 0; j < 10; j++) {
				if (!map.values().contains(j)) {
					if (j == 0 && w.length() - 1 == startPos) continue;
					map.put(c, j);
					sum += j;
					if (helper(words, result, startPos, i + 1, map, sum)) return true;
					map.remove(c);
					sum -= j;
				}
			}
			return false;
		}
		char ch = result.charAt(n - 1 - startPos);
		if (startPos == n - 1) {
			if (sum == 0 || map.containsKey(ch) && map.get(ch) != sum) return false;
		}
		
		if (map.containsKey(ch)) {
			if (sum % 10 != map.get(ch)) return false;
			return helper(words, result, startPos++, 0, map, sum / 10);
		}
		
		if (map.values().contains(sum % 10)) return false;
		map.put(ch, sum % 10);
		sum /= 10;
		return helper(words, result, startPos + 1, 0, map, sum / 10);
		
	}
	
	public static void main(String[] args) {
		Problem1307 problem = new Problem1307();
		System.out.println(problem.isSolvable(new String[] {"SEND", "MORE"},  "MONEY"));
	}
}
