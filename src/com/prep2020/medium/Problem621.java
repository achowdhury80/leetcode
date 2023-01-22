package com.prep2020.medium;
import java.util.*;
public class Problem621 {
	public int leastInterval(char[] tasks, int n) {
		if (n == 0) return tasks.length;
        int count = tasks.length;
        Queue<int[]> blocked = new LinkedList<>();
        for (int i = 0; i < n; i++) blocked.offer(new int[] {0, -1});
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (char t : tasks) {
        	int idx = t - 'A';
        	map.put(idx, map.getOrDefault(idx, 0) + 1);
        }
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
        	pq.offer(new int[] {entry.getKey(), entry.getValue()});
        while(count > 0) {
        	result++;
        	if (!pq.isEmpty()) {
        		int[] cur = pq.poll();
        		cur[1]--;
        		count--;
        		if (cur[1] > 0) blocked.offer(cur);
        		else blocked.offer(new int[] {0, -1});
        	} else blocked.offer(new int[] {0, -1});
        	int[] active = blocked.poll();
        	if (active[1] > -1) pq.offer(active);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem621 problem = new Problem621();
		System.out.println(problem.leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
	}
}
