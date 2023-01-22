package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2039 {
	public int networkBecomesIdle(int[][] edges, int[] patience) {
        Map<Integer, Set<Integer>> nexts = new HashMap<>();
        int maxNode = -1;
        for (int[] e : edges) {
        	Set<Integer> set = nexts.getOrDefault(e[0], new HashSet<>());
        	set.add(e[1]);
        	nexts.put(e[0], set);
        	set = nexts.getOrDefault(e[1], new HashSet<>());
        	set.add(e[0]);
        	nexts.put(e[1], set);
        	maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
        }
        int[] dis = new int[maxNode + 1];
        for (int i = 1; i <= maxNode; i++) dis[i] = -1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int path = 0;
        while(!q.isEmpty()) {
        	path++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		for (int next : nexts.get(cur)) {
        			if (dis[next] > -1) continue;
        			dis[next] = 2 * path;
        			q.offer(next);
        		}
        	}
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < dis.length; i++) {
        	int returnTime = dis[i];
        	int count = (returnTime - 1) / patience[i];
        	result = Math.max(result, count * patience[i] + dis[i] + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2039 problem = new Problem2039();
		System.out.println(problem.networkBecomesIdle(new int[][] {{0, 1}, {1, 2}}, 
				new int[] {0, 2, 1}));
	}
}
