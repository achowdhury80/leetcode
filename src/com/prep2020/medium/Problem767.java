package com.prep2020.medium;
import java.util.*;
public class Problem767 {
	public String reorganizeString(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] > 0) {
        		q.offer(new int[] {i, arr[i]});
        	}
        }
        StringBuilder sb = new StringBuilder();
        int[] cur = q.poll();
        cur[1]--;
        sb.append((char)(cur[0] + 'a'));
        if (cur[1] > 0) q.offer(cur);
        while (!q.isEmpty()) {
        	int[] largest = q.poll();
        	if (sb.charAt(sb.length() - 1) - 'a' == largest[0]) {
        		if (q.isEmpty()) return "";
        		int[] secondLargest = q.poll();
        		q.offer(largest);
        		sb.append((char)(secondLargest[0] + 'a'));
        		secondLargest[1]--;
        		if (secondLargest[1] > 0) q.offer(secondLargest);
        	} else {
        		sb.append((char)(largest[0] + 'a'));
        		largest[1]--;
        		if (largest[1] > 0) q.offer(largest);
        	}
        }
        return sb.toString();
    }
}
