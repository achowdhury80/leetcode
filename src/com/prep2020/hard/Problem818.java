package com.prep2020.hard;
import java.util.*;
public class Problem818 {
	public int racecar(int target) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0#1", 0);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 1});
        int count = 0;
        while(!q.isEmpty()) {
        	count++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		int [] next1 = new int[] {cur[0] + cur[1], 2 * cur[1]};
        		if (next1[0] == target) return count;
        		String key1 = next1[0] + "#" + next1[1];
        		if (next1[0] >= 0 && next1[0] <= 2 * target && !map.containsKey(key1)) {
        			map.put(key1, count);
        			q.offer(next1);
        		}
        		
        		int [] next2 = new int[] {cur[0], cur[1] > 0 ? -1 : 1};
        		key1 = next2[0] + "#" + next2[1];
        		if (next2[0] >= 0 && !map.containsKey(key1)) {
        			map.put(key1, count);
        			q.offer(next2);
        		}
        		
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Problem818 problem = new Problem818();
		System.out.println(problem.racecar(4));
	}
}
