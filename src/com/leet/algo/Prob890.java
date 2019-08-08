package com.leet.algo;
import java.util.*;
public class Prob890 {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<>();
		char[] arr2 = pattern.toCharArray();
		for (String w : words) {
			Map<Character, Character> map = new HashMap<>();
			char[] arr1 = w.toCharArray();
			Set<Character> seen = new HashSet<>();
			boolean flag = true;
			for (int i = 0; i < arr1.length; i++) {
				if (map.containsKey(arr2[i])) {
					if (map.get(arr2[i]) != arr1[i]) {
						flag = false;
						break;
					}
				} else {
					if (!seen.contains(arr1[i])) {
						map.put(arr2[i], arr1[i]);
						seen.add(arr1[i]);
					} else {
						flag = false;
						break;
					}
				}
			}
			if (flag) result.add(w);
		}
		return result;
    }
}
