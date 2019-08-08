package com.leet.algo;
import java.util.*;
public class Prob839 {
	/**
	 * instead of going through all combinations of swaping chars use list of string provided
	 * @param A
	 * @return
	 */
	public int numSimilarGroups(String[] A) {
		if (A.length == 1) return 1;
		Map<String, Boolean> visited = new HashMap<>();
		for (String a : A) visited.put(a, false);
		int result = 0;
        for (String a : A) {
        	if (visited.get(a)) continue;
        	result++;
        	Queue<String> q = new LinkedList<>();
        	q.offer(a);
        	visited.put(a, true);
        	while(!q.isEmpty()) {
        		String b = q.poll();
        		for (String key : visited.keySet()) {
        			if (!visited.get(key) && isSimilar(b, key)) {
        				q.offer(key);
        				visited.put(key, true);
        			}
        		}
        	}
        	
        }
        return result;
    }
	
	private boolean isSimilar(String str1, String str2) {
        int count=0;
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            if(count > 2) return false;
        }
        return true;
    }
}
