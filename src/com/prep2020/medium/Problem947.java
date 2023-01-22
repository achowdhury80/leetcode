package com.prep2020.medium;
import java.util.*;
public class Problem947 {
	/**
	 * find number of islands
	 * ans is stone.length -count of islands
	 * @param stones
	 * @return
	 */
	public int removeStones1(int[][] stones) {
        int[] parents = new int[stones.length];
        for (int i = 0; i < parents.length; i++) parents[i] = i;
        int[] islands = new int[] {stones.length};
        for (int i = 0; i < stones.length - 1; i++) {
        	for (int j = i + 1; j < stones.length; j++) {
        		if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
        			union(i, j, parents, islands);
        		}
        	}
        }
        return stones.length - islands[0];
    }
	
	private void union(int i, int j, int[] parents, int[] islands) {
		int parentI = findParent(parents, i);
		int parentJ = findParent(parents, j);
		if (parentI != parentJ) {
			islands[0]--;
			parents[parentI] = parentJ;
		}
		
	}
	
	private int findParent(int[] parents, int i) {
		while (i != parents[i]) i = parents[i];
		return i;
	}
    
    public int removeStones(int[][] stones) {
        int n = stones.length;
        Map<Integer, List<Integer>> xMap = new HashMap<>(), yMap =new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
        	List<Integer> list = xMap.getOrDefault(stones[i][0], new ArrayList<>());
        	list.add(i);
        	xMap.put(stones[i][0], list);
        	list = yMap.getOrDefault(stones[i][1], new ArrayList<>());
        	list.add(i);
        	yMap.put(stones[i][1], list);
        }
        int isLands = n;
        for (int i = 0; i < n; i++) {
        	if (visited[i]) continue;
            isLands++;
        	Queue<Integer> q = new LinkedList<>();
        	q.offer(i);
        	while(!q.isEmpty()) {
        		int cur = q.poll();
        		if (visited[cur]) continue;
        		visited[cur] = true;
        		isLands--;
        		List<Integer> list = xMap.get(stones[cur][0]);
        		for (int s : list) q.offer(s);
        		list = yMap.get(stones[cur][1]);
        		for (int s : list) q.offer(s);
        	}
        }
        return n - isLands;
    }
	
}
