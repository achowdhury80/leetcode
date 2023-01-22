package com.prep2020.medium;
import java.util.*;
public class Problem17 {
	/**
	 * O(4^N)
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() < 1) return result;
        result.add("");
        for (char c : digits.toCharArray()) {
        	String letters = findLetters(c);
        	List<String> temp = new ArrayList<>();
        	for (String s : result) {
        		for (char l : letters.toCharArray()) temp.add(s + l);
        	}
        	result = temp;
        }
        return result;
    }

	private String findLetters(char c) {
		String[] arr = new String[] {"abc", "def", "ghi", "jkl", "mno", 
				"pqrs", "tuv", "wxyz"};
		return arr[c - '2'];
	}
}
