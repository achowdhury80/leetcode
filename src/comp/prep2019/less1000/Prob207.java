package comp.prep2019.less1000;
import java.util.*;
public class Prob207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while(!q.isEmpty()) {
        	int course = q.poll();
        	finished++;
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
        return numCourses == finished;
        
    }
}
