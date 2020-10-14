package comp.prep2019.less1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Prob210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> indegreeMap = new HashMap<>();
        Map<Integer, List<Integer>> outdegreeMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
        	indegreeMap.put(prerequisite[0], indegreeMap.getOrDefault(prerequisite[0], 0) + 1);
        	List<Integer> list = outdegreeMap.getOrDefault(prerequisite[1], new ArrayList<>());
        	list.add(prerequisite[0]);
        	outdegreeMap.put(prerequisite[1], list);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
        	if (!indegreeMap.containsKey(i)) q.offer(i);
        }
        int finished = 0;
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
        	int course = q.poll();
        	finished++;
        	result.add(course);
        	if (outdegreeMap.containsKey(course)) {
        		for (int nextCourse : outdegreeMap.get(course)) {
        			int count = -1;
        			indegreeMap.put(nextCourse, (count = indegreeMap.get(nextCourse) - 1));
        			if (count == 0) {
        				indegreeMap.remove(nextCourse);
        				q.offer(nextCourse);
        			}
        		}
        	}
        }
        if (numCourses != finished) return new int[0];
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = result.get(i);
        return arr;
        
    }
}
