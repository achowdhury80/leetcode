package com.prep2020.medium;
import java.util.*;
public class Problem451 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String frequencySort(String s) {
       Map<Character, String> map = new HashMap<>();
       for (char c : s.toCharArray()) {
    	   if (map.containsKey(c)) map.put(c, map.get(c) + c);
    	   else map.put(c, "" + c);
       }
       Queue<String> pq = new PriorityQueue<>((x, y) -> y.length() - x.length());
       for (String str : map.values()) {
    	   if (!str.equals("")) pq.offer(str);
       }
       String result = "";
       while(!pq.isEmpty()) result += pq.poll();
       return result;
    }
}
