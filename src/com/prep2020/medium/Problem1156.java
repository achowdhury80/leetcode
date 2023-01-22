package com.prep2020.medium;
public class Problem1156 {
	public int maxRepOpt1(String text) {
		int[] count = new int[26];
		char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	count[arr[i] - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i];
        	int j = i, subCount = 0;
        	boolean used = false;
        	while(j < arr.length && (arr[j] == c || !used)) {
        		subCount++;
        		if (arr[j] != c) {
        			used = true;
        			i = j - 1;
        		}
        		if (!used || subCount <= count[c - 'a']) {
        			if (!used && subCount < count[c - 'a']) 
        				result = Math.max(result, subCount + 1);
        			else result = Math.max(result, subCount);
        		}
        		j++;
        	}
        }
        return result;
    }
}
