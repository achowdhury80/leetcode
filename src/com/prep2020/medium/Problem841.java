package com.prep2020.medium;
import java.util.*;
public class Problem841 {
	/**
	 * O(N)
	 * @param rooms
	 * @return
	 */
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
        	int room = q.poll();
        	if (keys.contains(room)) continue;
        	keys.add(room);
        	if (rooms.get(room) != null || rooms.get(room).size() > 0) {
        		q.addAll(rooms.get(room));
        	}
        }
        return keys.size() == rooms.size();
    }
}
