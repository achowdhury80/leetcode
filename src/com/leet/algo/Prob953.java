package com.leet.algo;

public class Prob953 {
	public boolean isAlienSorted(String[] words, String order) {
        int[] orderArr = new int[26];
        int idx = 0;
        for (char c : order.toCharArray()) {
        	orderArr[c - 'a'] = idx++;
        }
        for(int i = 1; i < words.length; i++) {
        	for (int j = 0, k = 0; j < words[i].length() || k < words[i - 1].length(); j++, k++) {
        		if (j == words[i].length()) {
        			return false;
        		} 
        		if (k == words[i - 1].length()) {
        			break;
        		} 
        		if (orderArr[words[i].charAt(j) - 'a'] < orderArr[words[i - 1].charAt(k) - 'a']) return false;
        		else if (orderArr[words[i].charAt(j) - 'a'] > orderArr[words[i - 1].charAt(k) - 'a']) break;
        	}
        	
        }
        return true;
    }
}
