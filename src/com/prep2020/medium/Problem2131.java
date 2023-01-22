package com.prep2020.medium;
import java.util.*;
public class Problem2131 {
	public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        List<String> keys = new ArrayList<>(map.keySet());
        int result = 0, middle = 0;
        for (String key : keys) {
        	if (!map.containsKey(key)) continue;
        	String revKey = "" + key.charAt(1) + "" + key.charAt(0);
        	int count = map.remove(key);
        	if (key.equals(revKey)) {
        		if (count % 2 == 1) middle = 2;
        		result += (count / 2) * 4;
        	} else {
        		if (!map.containsKey(revKey)) continue;
        		int revCount = map.remove(revKey);
        		result += Math.min(count, revCount) * 4;
        	}
        }
        return result + middle;
    }
	
	public static void main(String[] args) {
		Problem2131 problem = new Problem2131();
		System.out.println(problem.longestPalindrome(new String[] {"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"}));
	}
}
