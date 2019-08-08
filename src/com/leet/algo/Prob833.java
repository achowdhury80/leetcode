package com.leet.algo;
import java.util.*;
public class Prob833 {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < indexes.length; i++) {
        	if (S.indexOf(sources[i], indexes[i]) == indexes[i]) {
        		pq.offer(new int[] {indexes[i], i});
        	}
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(!pq.isEmpty()) {
        	int[] arr = pq.poll();
        	if (start < arr[0]) sb.append(S.substring(start, arr[0]));
        	sb.append(targets[arr[1]]);
        	start = arr[0] + sources[arr[1]].length();
        }
        if (start < S.length()) sb.append(S.substring(start));
        return sb.toString();
    }
}