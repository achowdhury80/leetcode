package com.leet.algo;
import java.util.*;
public class Prob893 {
	public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
        	int[][] evenOdd = new int[2][26];
        	for (int i = 0; i < s.length(); i++) {
        		evenOdd[i % 2][s.charAt(i) - 'a']++;
        	}
        	StringBuilder sb = new StringBuilder();
        	for (int i = 0; i < 2; i++) {
        		for(int j = 0; j < 26; j++) {
        			if (evenOdd[i][j] > 0) {
        				sb.append(evenOdd[i][j]);
        				sb.append((char)(j + 'a'));
        			}
        		}
        		sb.append(":");
        	}
        	set.add(sb.toString());
        }
        return set.size();
    }
	
	public static void main(String[] args) {
		System.out.println(new Prob893().numSpecialEquivGroups(new String[] {"abcd","cdab","cbad","xyzz","zzxy","zzyx"}));
	}
}
