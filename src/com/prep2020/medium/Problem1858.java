package com.prep2020.medium;

import java.util.*;

public class Problem1858 {
	public String longestWord(String[] words) {
        Arrays.sort(words, (x, y) -> (x.length() == y.length() ? x.compareTo(y) : (x.length() - y.length())));
        String result = "";
        Map<String, Integer> wordIndex = new HashMap<>();
        boolean[] arr = new boolean[words.length];
        int lastValidSize = 0;
        for (int i = 0; i < words.length; i++) {
        	wordIndex.put(words[i], i);
        	if (words[i].length() == 1) {
        		arr[i] = true;
        		lastValidSize = 1;
        		if ("".equals(result)) result = words[i];
        		continue;
        	}
        	if (words[i].length() - 1 > lastValidSize) break;
        	String subStr = words[i].substring(0, words[i].length() - 1);
        	if (wordIndex.containsKey(subStr) && arr[wordIndex.get(subStr)]) {
        		arr[i] = true;
        		if (result.length() < words[i].length()) result = words[i];
        		lastValidSize = words[i].length();
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1858 problem = new Problem1858();
		System.out.println(problem.longestWord(new String[] {"k","ki","kir","kira","kiran"}));
	}
}
