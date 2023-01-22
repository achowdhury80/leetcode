package com.prep2020.easy;

import java.util.*;

public class Problem500 {
	/**
	 * O(m * n) where m = no of words and n = avg length of word
	 * @param words
	 * @return
	 */
	public String[] findWords(String[] words) {
	    if(words == null || words.length == 0) return new String[0];
	    Map<Character, Integer> map = new HashMap<>();
	    String[] rows = new String[] {"qwertyuiop", "asdfghjkl]", "zxcvbnm"};
	    for (int i = 0; i < rows.length; i++) {
	    	for (char c : rows[i].toCharArray()) {
	    		map.put(c, i);
	    	}
	    }
	    List<String> result = new ArrayList<>();
	    for (String w : words) {
	    	int last = -1;
	    	boolean flag = true;
	    	for (char c : w.toCharArray()) {
	    		c = Character.toLowerCase(c);
	    		if (last != -1 && rows[last].indexOf(c) < 0) {
	    			flag = false;
	    			break;
	    		} else if (last == -1) {
	    			for (int i = 0; i < rows.length; i++) {
	    				if (rows[i].indexOf(c) > -1) {
	    					last = i;
	    					break;
	    				}
	    			}
	    		}
	    	}
	    	if (flag) result.add(w);
	    }
	    return result.toArray(new String[0]);
	  }
}
