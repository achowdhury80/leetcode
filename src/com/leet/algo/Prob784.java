package com.leet.algo;
import java.util.*;
public class Prob784 {
	public List<String> letterCasePermutation(String S) {
		List<Integer> charIndex = new ArrayList<>();
		char[] arr = S.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (Character.isLetter(arr[i])) charIndex.add(i); 
		}
		int permutations = (int) Math.pow(2, charIndex.size());
		List<String> result = new ArrayList<>();
		result.add(S);
		for (int i = 1; i < permutations; i++) {
			StringBuilder sb = new StringBuilder(S);
			List<Integer> toggleBits = findToggleBitIndex(i);
			for (int j : toggleBits) {
				int idx = charIndex.get(j);
				if (Character.isLowerCase(arr[idx])) {
					sb.setCharAt(idx, Character.toUpperCase(arr[idx]));
				} else {
					sb.setCharAt(idx, Character.toLowerCase(arr[idx]));
				}
			}
			result.add(sb.toString());
		}
		return result;
	}
	
	private List<Integer> findToggleBitIndex(int i){
		List<Integer> result = new ArrayList<>();
		int k = 0;
		while(i > 0) {
			if ((i & 1) == 1) result.add(k);
			i >>= 1;
			k++;
		}
		return result;
	}
}
