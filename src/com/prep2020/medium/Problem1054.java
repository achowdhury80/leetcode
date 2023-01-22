package com.prep2020.medium;
import java.util.*;
public class Problem1054 {
	public int[] rearrangeBarcodes(int[] barcodes) {
        int[] result = new int[barcodes.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : barcodes) map.put(i, map.getOrDefault(i, 0) + 1);
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	q.offer(new int[] {entry.getKey(), entry.getValue()});
        }
        int i = 0;
        int[] last = null;
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	result[i++] = cur[0];
        	cur[1]--;
        	if (last != null) q.offer(last);
        	last = null;
        	if (cur[1] == 0) continue;
        	last = cur;
        }
        if (last != null) result[i] = last[0];
        return result;
    }
}
