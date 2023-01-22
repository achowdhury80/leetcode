package com.prep2020.medium;
import java.util.*;
public class Problem210 {
	/**
	 * O(N) time and space
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> dependencyMap = new HashMap<>();
        int[] indeg = new int[numCourses]; 
        for (int[] preReq : prerequisites) {
        	indeg[preReq[0]]++;
        	List<Integer> outgoingList = dependencyMap.getOrDefault(preReq[1], 
        			new ArrayList<>());
        	outgoingList.add(preReq[0]);
        	dependencyMap.put(preReq[1], outgoingList);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
        	if (indeg[i] == 0) q.offer(i);
        }
        int idx = -1;
        int[] result = new int[numCourses];
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int course = q.poll();
        		result[++idx] = course;
        		if (dependencyMap.containsKey(course)) {
        			for (int c : dependencyMap.get(course)) {
        				indeg[c]--;
        				if (indeg[c] == 0) q.offer(c);
        			}
        		}
        	}
        }
        return numCourses == idx + 1 ? result : new int[0];
    }
}
