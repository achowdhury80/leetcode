package com.prep2020.medium;

public class Problem1061 {
	public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parents = new int[26];
        for (int i = 0; i < 26; i++) parents[i] = i;
        for (int i = 0; i < s1.length(); i++) {
        	int c1 = s1.charAt(i) - 'a', c2 = s2.charAt(i) - 'a';
        	int p1 = findParent(parents, c1), p2 = findParent(parents, c2);
        	if (p1 < p2) parents[p2] = p1;
        	else parents[p1] = p2;
        }
        String result = "";
        for (char c : baseStr.toCharArray()) {
        	result += (char)(findParent(parents, c - 'a') + 'a');
        }
        return result;
    }
	
	private int findParent(int[] parents, int i) {
		while(parents[i] != i) i = parents[i];
		return i;
	}
}
