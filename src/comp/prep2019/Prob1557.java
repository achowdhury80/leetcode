package comp.prep2019;
import java.util.*;
public class Prob1557 {
	/**
	 * O(n + e) time and o(n) space
	 * @param n
	 * @param edges
	 * @return
	 */
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegrees = new int[n];
        for (List<Integer> edge : edges) {
        	indegrees[edge.get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	if (indegrees[i] == 0) result.add(i);
        }
        return result;
    }
}
