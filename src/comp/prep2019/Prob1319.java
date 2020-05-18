package comp.prep2019;

public class Prob1319 {
	/**
	 * if number of connections less than n-1 then not possible
	 * use union find
	 * find number of unique parent; that many island
	 * we need no of islands - 1 wires
	 * @param n
	 * @param connections
	 * @return
	 */
	public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] con : connections) {
        	int p1 = findParent(parent, con[0]);
        	int p2 = findParent(parent, con[1]);
        	if (p1 != p2) {
        		if (p1 > p2) parent[p1] = p2;
        		else parent[p2] = p1;
        	}
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) if (parent[i] == i) count++;
        return count - 1;
    }
	
	private int findParent(int[] parent, int i) {
		while(parent[i] != i) i = parent[i];
		return i;
	}
}
