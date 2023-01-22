package com.prep2020.medium;
import java.util.*;
public class Problem582 {
	/**
	 * O(N) time and space
	 * @param pid
	 * @param ppid
	 * @param kill
	 * @return
	 */
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> childMap = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
        	int parent = ppid.get(i);
        	Set<Integer> children = childMap.getOrDefault(parent, new HashSet<>());
        	children.add(pid.get(i));
        	childMap.put(parent, children);
        }
        
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(kill);
        while(!q.isEmpty()) {
        	int process = q.poll();
        	result.add(process);
        	if (childMap.containsKey(process)) {
        		for (Integer child : childMap.get(process)) q.offer(child);
        	}
        }
        return result;
    }
}
