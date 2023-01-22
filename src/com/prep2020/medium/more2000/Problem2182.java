package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2182 {
	public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int i = 0; i < 26; i++) {
        	if (arr[i] > 0) pq.offer(new int[] {i, arr[i]});
        }
        
        int[] blocked = null;
        while(!pq.isEmpty()) {
        	int[] next = pq.poll();
        	int count = 0;
        	for (int i = 0; i < Math.min(repeatLimit, next[1]); i++) {
        		count++;
        		sb.append((char)(next[0] + 'a'));
        		if (blocked != null && blocked[0] > next[0]) break;
        	}
        	next[1] -= count;
        	if (blocked != null) {
        		pq.offer(blocked);
        		blocked = null;
        	}
        	if (next[1] > 0) blocked = next;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Problem2182 problem = new Problem2182();
		System.out.println(problem.repeatLimitedString("cczazcc", 3));
	}
}
