package comp.prep2019;
import java.util.*;
public class Prob1136 {
	/**
	 * Maintain an indegree count and next node list for each node
	 * add nodes which has indegree 0
	 * 
	 * @param N
	 * @param relations
	 * @return
	 */
	public int minimumSemesters(int N, int[][] relations) {
        int[] indegree = new int[N + 1];
        List<Integer>[] nexts = new List[N + 1];
        for (int[] rel : relations) {
        	indegree[rel[1]]++;
        	List<Integer> list = nexts[rel[0]];
        	if (list == null) nexts[rel[0]] = new ArrayList<>();
        	nexts[rel[0]].add(rel[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) if (indegree[i] == 0) q.offer(i);
        int result = 0, count = 0;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		count++;
        		if (nexts[cur] != null) {
        			for (int c : nexts[cur]) {
        				indegree[c]--;
        				if (indegree[c] == 0) q.offer(c);
        			}
        		}
        	}
        }
        return count == N ? result : -1;
    }
}
