package com.leet.algo;
import java.util.*;
public class Prob433 {
	public int minMutation(String start, String end, String[] bank) {
        char[] chars = new char[] {'A', 'C', 'G', 'T'};
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        Set<String> seen = new HashSet<>();
        seen.add(start);
        Set<String> set = new HashSet<>();
        for (String s : bank) set.add(s);
        set.remove(start);
        if (!set.contains(end)) return -1;
        int result = 0;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for(int i = 0; i < size; i++) {
        		String g = q.poll();
        		for (int j = 0; j < g.length(); j++) {
        			for (int k = 0; k < chars.length; k++) {
        				if (g.charAt(j) != chars[k]) {
        					String newG = "";
        					if (j == 0) {
        						newG = chars[k] + g.substring(1);
        					} else if (j == g.length() - 1) {
        						newG = g.substring(0, g.length() - 1) + chars[k];
        					} else {
        						newG = g.substring(0, j) + chars[k] + g.substring(j + 1);
        					}
        					if (set.contains(newG) && !seen.contains(newG)) {
        						q.offer(newG);
        						if(newG.equals(end)) return result;
        					}
        				}
        			}
        		}
        	}
        }
        return -1;
    }
}
