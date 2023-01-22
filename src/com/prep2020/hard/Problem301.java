package com.prep2020.hard;
import java.util.*;

public class Problem301 {
	/**
	 * 
	 * @param s
	 * @return
	 */
	public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(s);
        q.offer(s);
        List<String> result = new ArrayList<>();
        boolean found = false;
        while(!q.isEmpty() && !found) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		String cur = q.poll();
        		if (isValid(cur)) {
        			found = true;
        			result.add(cur);
        		}
        		if (found) continue;
        		for (int j = 0; j < cur.length(); j++) {
        			String sub = cur.substring(0, j) + cur.substring(j + 1, cur.length());
        			if (visited.contains(sub)) continue;
        			visited.add(sub);
        			q.offer(sub);
        		}
        	}
        }
        return result;
    }
	
	private boolean isValid(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') count++;
			else if (c == ')') count--;
			if (count < 0) return false;
		}
		return count == 0;
	}
}
