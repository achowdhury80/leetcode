package comp.prep2019.less1000;
import java.util.*;
public class Prob261 {
	/**
	 * O(N +E) time and O(N) space
	 * @param n
	 * @param edges
	 * @return
	 */
	public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
        	int[] e = edges[i];
        	List<Integer> l1 = map.getOrDefault(e[0], new ArrayList<>());
        	List<Integer> l2 = map.getOrDefault(e[1], new ArrayList<>());
        	l1.add(e[1]);
        	l2.add(e[0]);
        	map.put(e[0], l1);
        	map.put(e[1], l2);
        }
        int[] color = new int[n];
        int[] count = new int[] {0};
        if (!helper(0, color, count, map, -1)) return false;
        return count[0] == n;
    }
	
	private boolean helper(int node, int[] color, int[] count, 
			Map<Integer, List<Integer>> map, int parent) {
		if (color[node] == 2) return true;
		if (color[node] == 1) return false;
		color[node] = 1;
		if (map.containsKey(node)) {
			for (int next : map.get(node)) {
				if (next == parent) continue;
				if (!helper(next, color, count, map, node)) return false;
			}
		}
		color[node] = 2;
		count[0]++;
		return true;
	}
	
	public static void main(String[] args) {
		Prob261 prob = new Prob261();
		System.out.println(prob.validTree(5, new int[][] {{0, 1}, {0, 2}, {0, 3},
			{1, 4}}));
	}
}
