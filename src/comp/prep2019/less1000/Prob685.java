package comp.prep2019.less1000;
import java.util.*;
public class Prob685 {
	public int[] findRedundantDirectedConnection(int[][] edges) {
        int[][] arr = new int[edges.length + 1][2];
        for (int i = 1; i <= edges.length; i++) arr[i][0] = i;
        for (int[] edge : edges) {
        	int[] p1 = find(arr, edge[0]);
        	int[] p2 = find(arr, edge[1]);
        	if (p1[0] == p2[0]) return edge;
        	union(arr, p1, p2);
        }
        return null;
    }
	
	//path compression
	private int[] find(int[][] arr, int node) {
		List<Integer> nodes = new ArrayList<>();
		while(arr[node][0] != node) {
			nodes.add(node);
			node = arr[node][0];
		}
		for (int e : nodes) {
			arr[e][0] = node;
		}
		return arr[node];
	}
	
	// refer to coursera union find path compression
	private void union(int[][] arr, int[] p1, int[] p2) {
		if (p1[1] > p2[1]) {
			arr[p2[0]][0] = p1[0];
		} else if (p1[1] == p2[1]) {
			arr[p2[0]][0] = p1[0];
			arr[p1[0]][1]++;
		} else {
			arr[p1[0]][0] = p2[0];
		}
	}
}
