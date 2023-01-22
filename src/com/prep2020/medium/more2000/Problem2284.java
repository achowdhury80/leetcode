package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2284 {
	public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < senders.length; i++) {
        	int count = map.getOrDefault(senders[i], 0);
        	count += messages[i].split(" ").length;
        	map.put(senders[i], count);
        }
        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
        	if (e.getValue() > maxCount) {
        		maxCount = e.getValue();
        		result = e.getKey();
        	} else if (e.getValue() == maxCount && e.getKey().compareTo(result) > 0) result = e.getKey();
        }
        return result;
    }
}
