package com.leet.algo;
import java.util.*;
public class Prob830 {
	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> result = new ArrayList<>();
        int lastIndex = 0;
        char lastChar = S.charAt(0);
        for (int i = 0; i < S.length(); i++) {
        	char c;
        	if ((c = S.charAt(i)) != lastChar) {
        		if (i - lastIndex > 2) {
        			result.add(Arrays.asList(new Integer[] {lastIndex, i - 1}));
        		}
        		lastIndex = i;
        		lastChar = c;
        	}
        }
        if (S.charAt(S.length() - 1) == lastChar) {
    		if (S.length() - lastIndex > 2) {
    			result.add(Arrays.asList(new Integer[] {lastIndex, S.length() - 1}));
    		}
    	}
        return result;
        
    }
}
