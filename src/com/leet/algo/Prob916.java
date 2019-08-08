package com.leet.algo;
import java.util.*;
public class Prob916 {
	public List<String> wordSubsets(String[] A, String[] B) {
		int[] charMap = new int[26];
		for (String w : B) {
			int[] charCount = generateCharMap(w);
			for (int i = 0; i < 26; i++) {
				if (charCount[i] > charMap[i]) charMap[i] = charCount[i];
			}
		}
		List<String> result = new ArrayList<>();
		for (String w : A) {
			int[] charCount = generateCharMap(w);
			boolean flag = true;
			for (int i = 0; i < 26; i++) {
				if (charCount[i] < charMap[i]) {
					flag = false;
					break;
				}
			}
			if (flag) result.add(w);
		}
		return result;
    }
	
	private int[] generateCharMap(String word) {
		int[] result = new int[26];
		for (char c : word.toCharArray()) {
			result[c - 'a']++;
		}
		return result;
	}
}
