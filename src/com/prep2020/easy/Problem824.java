package com.prep2020.easy;

public class Problem824 {
	/**
	 * O(N) time and space because of aas
	 * @param S
	 * @return
	 */
	public String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        String aas = "a";
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i].charAt(0);
        	sb.append(" ");
        	if ("aeiou".indexOf(Character.toLowerCase(c)) < 0) {
        		sb.append(arr[i].substring(1));
        		sb.append(c);
        	} else sb.append(arr[i]);
        	sb.append("ma");
        	sb.append(aas);
        	aas += "a";
        }
        return sb.toString().substring(1);
    }
}
