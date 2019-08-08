package com.leet.algo;
import java.util.*;
public class Prob841 {
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()) {
        	int room = q.poll();
        	List<Integer> keys = rooms.get(room);
        	visited.add(room);
        	for (int key : keys) {
        		if (!visited.contains(key)) {
        			q.offer(key);
        		}
        	}
        }
        return visited.size() == rooms.size();
    }
}
