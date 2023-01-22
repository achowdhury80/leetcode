package com.prep2020.easy;
import java.util.*;
public class Problem1763 {
	public String longestNiceSubstring(String s) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> (y[1] - y[0]) == (x[1] - x[0]) ? 
        		(x[0] - y[0]) : (y[1] - y[0] - x[1] + x[0]));
        q.offer(new int[] {0, s.length() - 1});
        while(!q.isEmpty()) {
        	int[] interval = q.poll();
        	List<int[]> intervals = findNiceStringIntervals(s, interval);
        	if (intervals.size() == 1 && intervals.get(0)[0] == interval[0] && intervals.get(0)[1] == interval[1]) 
        		return s.substring(intervals.get(0)[0], 
        			intervals.get(0)[1] + 1);
        	for (int[] arr : intervals) {
        		q.offer(arr);
        	}
        }
        return "";
    }
	
	
	
	private List<int[]> findNiceStringIntervals(String s, int[] interval) {
		boolean[][] charFound = new boolean[26][2];
		for (int i = interval[0]; i <= interval[1]; i++) {
			char c = s.charAt(i);
			if(Character.isLowerCase(c)) {
				charFound[c - 'a'][0] = true;
			} else {
				char lower = Character.toLowerCase(c);
				charFound[lower - 'a'][1] = true;
			}
		}
		
		List<int[]> result = new ArrayList<>();
		for (int i = interval[0]; i <= interval[1]; i++) {
			char c = Character.toLowerCase(s.charAt(i));
			if (!charFound[c - 'a'][0] || !charFound[c - 'a'][1]) {
				if (i > interval[0] + 1) result.add(new int[] {interval[0], i - 1});
				if (i < interval[1] - 1) result.add(new int[] {i + 1, interval[1]});
				return result;
			}
		}
		
		result.add(interval);
		return result;
		
	}
	
	public static void main(String[] args) {
		Problem1763 problem = new Problem1763();
		System.out.println(problem.longestNiceSubstring("YazaAay"));
	}
	
	
}
