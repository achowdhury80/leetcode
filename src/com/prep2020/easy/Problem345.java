package com.prep2020.easy;

public class Problem345 {
	/*
	 * O(N)
	 */
	public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();
        while(i < j) {
        	if ("aeiou".indexOf(Character.toLowerCase(s.charAt(i))) < 0) {
        		i++;
        		continue;
        	}
        	if ("aeiou".indexOf(Character.toLowerCase(s.charAt(j))) < 0) {
        		j--;
        		continue;
        	}
        	char temp = arr[i];
        	arr[i] = arr[j];
        	arr[j] = temp;
        	i++;
        	j--;
        }
        return new String(arr);
    }
}
