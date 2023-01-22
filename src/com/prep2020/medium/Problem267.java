package com.prep2020.medium;
import java.util.*;
public class Problem267 {
	/**
	 * O(N!) time
	 * O(N) space 
	 * @param s
	 * @return
	 */
	public List<String> generatePalindromes(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        List<Character> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        boolean middleFound = false;
        char middle = '\0';
        for (int i = 0; i < 26; i++) {
        	if (count[i] % 2 == 1) {
        		if (middleFound) return result;
        		middleFound = true;
        		middle = (char)(i + 'a');
        		count[i]--;
        	} 
        	if (count[i] > 0) {
        		for (int j = 0; j < count[i] / 2; j++) list.add((char)(i + 'a'));
        	}
        }
        List<String> permutations = permutate(list);
        for (String st : permutations) {
        	result.add(st + (middleFound ? middle : "") 
        			+ new StringBuilder(st).reverse().toString());
        }
        return result;
    }

	private List<String> permutate(List<Character> list) {
		List<String> result = new ArrayList<>();
		helper(list, new boolean[list.size()], "", result);
		return result;
	}
	
	private void helper(List<Character> list, boolean[] used, String cur, List<String> result) {
		if (cur.length() == list.size()) {
			result.add(cur);
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (used[i] || (i > 0 && list.get(i - 1) == list.get(i) 
					&& !used[i - 1])) continue;
			used[i] = true;
			helper(list, used, cur + list.get(i), result);
			used[i] = false;
		}
	}
}
