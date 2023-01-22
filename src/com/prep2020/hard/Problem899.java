package com.prep2020.hard;
import java.util.*;
public class Problem899 {
	/**
	 * https://leetcode.com/problems/orderly-queue/solution/
	 * @param args
	 */
	public String orderlyQueue(String s, int k) {
		if (k == 1) {
			String result = s;
			for (int i = 1; i < s.length(); i++) {
				String t = s.substring(i) + s.substring(0, i);
				if (t.compareTo(result) < 0) result = t;
			}
			return result;
		} else {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			return new String(arr);
		}
	}
	/*public String orderlyQueue(String s, int k) {
        String result = s;
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
        while(!q.isEmpty()) {
        	String st = q.poll();
        	for (int i = 0; i < k; i++) {
        		String newS = st.substring(0, i) + st.substring(i + 1) 
        			+ st.charAt(i);
        		if (!visited.contains(newS)) {
        			visited.add(newS);
        			q.offer(newS);
        			if (result.compareTo(newS) > 0) result = newS;
        		}
        	}
        }
        return result;
    }*/
	
	public static void main(String[] args) {
		Problem899 problem = new Problem899();
		//System.out.println(problem.orderlyQueue("cba", 1));
		System.out.println(problem.orderlyQueue("baaca", 3));
	}
}
