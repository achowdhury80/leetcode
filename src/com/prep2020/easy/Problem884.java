package com.prep2020.easy;
import java.util.*;
public class Problem884 {
	/**
	 * O(N) time and space
	 * @param A
	 * @param B
	 * @return
	 */
	public String[] uncommonFromSentences(String A, String B) {
        Map<String, Boolean> map = new HashMap<>();
        String[] arr = A.split(" ");
        for (String s : arr) {
        	if (map.containsKey(s)) map.put(s, false);
        	else map.put(s, true);
        }
        
        arr = B.split(" ");
        for (String s : arr) {
        	if (map.containsKey(s)) map.put(s, false);
        	else map.put(s, true);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
        	if (entry.getValue()) list.add(entry.getKey());
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
