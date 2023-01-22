package com.prep2020.medium;
import java.util.*;
public class Problem752 {
	public int openLock(String[] deadends, String target) {
		if ("0000".equals(target)) return 0;
        Set<String> used = new HashSet<>();
        for (String s : deadends) used.add(s);
        if (used.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        used.add("0000");
        int result = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	result++;
        	for (int i = 0; i < size; i++) {
        		String cur = q.poll();
        		List<String> nexts = findNexts(cur);
        		for (String next : nexts) {
        			if (used.contains(next)) continue;
        			if (target.equals(next)) return result;
        			used.add(next);
        			q.offer(next);
        		}
        	}
        }
        return -1;
    }
	
	private List<String> findNexts(String cur) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			char c = cur.charAt(i);
			result.add(cur.substring(0, i) + (c == '9' ? '0' : (char)(c + 1)) 
					+ cur.substring(i + 1));
			result.add(cur.substring(0, i) + (c == '0' ? '9' : (char)(c - 1)) 
					+ cur.substring(i + 1));
		}
		return result;
	}
}
