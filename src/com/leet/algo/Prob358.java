package com.leet.algo;
import java.util.*;
public class Prob358 {
	/** 
	 * O(n) time and space
	 * find char freq
	 * put map.entry in max heap - key count
	 * poll value and append to result
	 * decrement map entry count 
	 * put the map entry in a queue
	 * the q will keep the map entry invisible for k steps
	 * @param s
	 * @param k
	 * @return
	 */
	public String rearrangeString(String s, int k) {
		if (k < 1) return s;
        Map<Character, Integer> charMap = new HashMap<>();
        // compute char freq
        char[] arr = s.toCharArray();
        for (char c : arr) {
        	charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        //max heap based on count
        PriorityQueue<Map.Entry<Character, Integer>> pq 
        	= new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        // add all map entries to pq
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) pq.offer(entry);
        StringBuilder result = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> q = new LinkedList<>();
        while(!pq.isEmpty()) {
        	Map.Entry<Character, Integer> entry = pq.poll();
        	result.append(entry.getKey());
        	entry.setValue(entry.getValue() - 1);
        	q.offer(entry);
        	if (q.size() == k) {
        		Map.Entry<Character, Integer> oldEntry = q.poll();
        		if(oldEntry.getValue() > 0) pq.offer(oldEntry);
         	}
        }
        if (result.length() < s.length()) return "";
        return result.toString();
        
    }
}
