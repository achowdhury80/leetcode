package com.prep2020.medium;
import java.util.*;
public class Problem1311 {
	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, 
			int level) {
		int n = friends.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        int curLevel = 0;
        boolean[] visited = new boolean[n];
        visited[id] = true;
        while(!q.isEmpty() && curLevel < level) {
        	curLevel++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		for (int f : friends[cur]) {
        			if (visited[f]) continue;
        			visited[f] = true;
        			q.offer(f);
        		}
        	}
        }
        Map<String, Integer> map = new HashMap<>();
        while(!q.isEmpty()) {
        	int f = q.poll();
        	for (String v : watchedVideos.get(f)) map.put(v, map.getOrDefault(v, 0) + 1);
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (x, y) -> (x.getValue() == y.getValue() ? x.getKey().compareTo(y.getKey()) 
        		: (x.getValue() - y.getValue())));
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) result.add(entry.getKey());
        return result;
    }
}
