package comp.prep2019;

public class Prob684 {
	private int[] arr;
	public int[] findRedundantConnection(int[][] edges) {
		arr = new int[1001];
		for (int i = 0; i < arr.length; i++) arr[i] = i;
        for (int[] edge : edges) {
        	int pt1Parent = findParent(arr, edge[0]);
        	int pt2Parent = findParent(arr, edge[1]);
        	if (pt1Parent == pt2Parent) return edge;
        	arr[Math.max(pt2Parent, pt1Parent)] = Math.min(pt1Parent, pt2Parent);
        }
        return new int[1];
    }
	
	private int findParent(int[] arr, int node) {
		while (arr[node] != node) node = arr[node];
		return node;
	}
	
	
}
