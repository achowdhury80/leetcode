package com.prep2020.hard;
import java.util.*;
public class Problem1579 {
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		Map<Integer, List<int[]>> nexts = new HashMap<>();
		for (int[] e : edges) {
			List<int[]> list = nexts.getOrDefault(e[1], new ArrayList<>());
			list.add(new int[] {e[2], e[0]});
			nexts.put(e[1], list);
			list = nexts.getOrDefault(e[2], new ArrayList<>());
			list.add(new int[] {e[1], e[0]});
			nexts.put(e[2], list);
		}
        boolean[][] reachable = new boolean[n + 1][2]; // 0 for red 1 for green;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        reachable[1] = new boolean[] {true, true};
        int reachCount = 2;
        for (int[] a : nexts.get(1)) {
        	pq.offer(a);
        }
        int result = 0;
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[1] == 3) {
        		if (reachable[cur[0]][0] && reachable[cur[0]][1]) {
        			result++;
        			continue;
        		}
        		reachable[cur[0]][0] = true;
        		reachable[cur[0]][1] = true;
        	} else if (cur[1] == 1) {
        		if (reachable[cur[0]][0]) {
        			result++;
        			continue;
        		}
        		for (int[] edge : nexts.get(cur[0])) {
        			if (edge[1] != 1 || reachable[edge[0]][0]) continue;
        			reachable[edge[0]][0] = true;
        		}
        	} else {
        		if (reachable[cur[0]][1]) {
        			result++;
        			continue;
        		}
        	}
        }
        return reachCount == 2 * n ? result : -1;
    }
}
