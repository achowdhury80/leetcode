package com.prep2020.hard;
import java.util.*;
public class Problem358 {
	public String rearrangeString(String s, int k) {
		if (k < 2) return s;
        int[] arr = new int[26];
        for (char c : s.toCharArray()) arr[c - 'a']++;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] > 0) pq.offer(new int[] {i, arr[i]});
        }
        StringBuilder sb = new StringBuilder();
        Queue<int[]> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()) {
        	if (q.size() == k) {
        		int[] used = q.poll();
        		if (used[1] != 0) pq.offer(used);
        	}
        	if (pq.isEmpty()) break;
        	int[] cur = pq.poll();
        	sb.append((char)(cur[0] + 'a'));
        	cur[1]--;
        	q.offer(cur);
        }
        
        while (!q.isEmpty()) {
        	int[] cur = q.poll();
        	if (cur[1] > 0) return "";
        }
        return sb.toString();
    }
}
