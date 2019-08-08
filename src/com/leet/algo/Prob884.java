package com.leet.algo;
import java.util.*;
public class Prob884 {
	public String[] uncommonFromSentences(String A, String B) {
        Map<String, Boolean> map = new HashMap<>();
        int count = 0;
        for (String word : A.split(" ")) {
        	if (map.containsKey(word)) {
        		if (map.get(word)) count--;
        		map.put(word, false);
        	}
        	else {
        		map.put(word, true);
        		count++;
        	}
        }
        for (String word : B.split(" ")) {
        	if (map.containsKey(word)) {
        		if (map.get(word)) count--;
        		map.put(word, false);
        	}
        	else {
        		map.put(word, true);
        		count++;
        	}
        }
        String[] result = new String[count];
        int idx = 0;
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
        	if (entry.getValue()) result[idx++] = entry.getKey();
        }
        return result;
    }
}
