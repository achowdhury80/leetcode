package com.leet.algo;
import java.util.*;
public class Prob1002 {
	public List<String> commonChars(String[] A) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : A[0].toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
        for (int i = 1; i < A.length; i++) {
        	char[] arr = A[i].toCharArray();
        	Map<Character, Integer> temp = new HashMap<>();
        	for (char c : arr) {
        		if (map.containsKey(c)) {
        			map.put(c, map.get(c) - 1);
        			if (map.get(c) == 0) map.remove(c);
        			temp.put(c, temp.getOrDefault(c, 0) + 1);
        		}
        	}
        	map = temp;
        	if (map.isEmpty()) break;
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        	for (int i = 0; i < entry.getValue(); i++) {
        		result.add(entry.getKey() + "");
        	}
        }
        return result;
    }
}
