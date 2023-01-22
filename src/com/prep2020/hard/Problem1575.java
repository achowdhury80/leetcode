package com.prep2020.hard;
import java.util.*;
public class Problem1575 {
	public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long mod = (long)(1e9 + 7);
        Map<String, Long> map = new HashMap<>();
        Set<Integer> locs = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int l : locations) {
        	locs.add(l);
        	max = Math.max(max, l);
        	min = Math.min(min, l);
        }
        int startDigit = locations[start], endDigit = locations[finish];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startDigit, 0});
        map.put("" + startDigit + "#0", 1l);
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	for (int i = 1; i <= fuel - cur[1]; i++) {
        		int next = cur[0] + i;
        		if (next > max) break;
        		if (locs.contains(next)) {
        			String key = "" + next + "#" + (cur[1] + i);
        			long existingVal = map.getOrDefault(key, 0l);
        			existingVal = (existingVal + 1) % mod;
        			map.put(key, existingVal);
        			q.offer(new int[] {next, cur[1] + i});
        		}
        	}
        	
        	for (int i = 1; i <= fuel - cur[1]; i++) {
        		int next = cur[0] - i;
        		if (next < min) break;
        		if (locs.contains(next)) {
        			String key = "" + next + "#" + (cur[1] + i);
        			long existingVal = map.getOrDefault(key, 0l);
        			existingVal = (existingVal + 1) % mod;
        			map.put(key, existingVal);
        			q.offer(new int[] {next, cur[1] + i});
        		}
        	}
        }
        
        long result = 0l;
        for (int i = 0; i <= fuel; i++) {
        	String key = "" + endDigit + "#" + i;
        	if (map.containsKey(key)) result = (result + map.get(key)) % mod;
        }
        return (int) result;
    }
	
	public static void main(String[] args) {
		Problem1575 problem = new Problem1575();
		//System.out.println(problem.countRoutes(new int[] {2, 3, 6, 8, 4}, 1, 3, 5));
		System.out.println(problem.countRoutes(new int[] {2, 1, 5}, 0, 0, 3));
	}
}
