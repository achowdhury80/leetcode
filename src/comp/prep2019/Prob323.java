package comp.prep2019;
import java.util.*;
public class Prob323 {
	public int countComponents(int n, int[][] edges) {
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) parent[i] = i;
		int result = n;
		for (int[] edge : edges) { 
			int p1 = findParent(parent, edge[0]);
			int p2 = findParent(parent, edge[1]);
			if (p1 != p2) {
				result--;
				parent[Math.max(p1, p2)] = Math.min(p1, p2);
			}
		}
        
        return result;
    }
	
	private int findParent(int[] parent, int node) {
		while(parent[node] != node) node = parent[node];
		return node;
	}
}
