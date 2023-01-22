package com.prep2020.easy;
import java.util.*;
public class Problem1408 {
	/**
	 * O(N^2)
	 * @param words
	 * @return
	 */
	public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
        	String w = words[i];
        	for (int j = i + 1; j < words.length; j++) {
        		if (words[j].indexOf(w) > -1) {
        			result.add(w);
        			break;
        		}
        	}
        }
        return result;
    }
}
