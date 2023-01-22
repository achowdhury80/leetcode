package com.prep2020.easy;
import java.util.*;
public class Problem804 {
	/**
	 * n = total number of chars across all strings
	 * O(N) time and space
	 * @param words
	 * @return
	 */
	public int uniqueMorseRepresentations(String[] words) {
        String[] t = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",
        		".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
        		"...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String w : words) {
        	StringBuilder sb = new StringBuilder();
        	for (char c : w.toCharArray()) {
        		sb.append(t[c - 'a']);
        	}
        	set.add(sb.toString());
        }
        return set.size();
    }
}
