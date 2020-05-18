package comp.prep2019;
import java.util.*;
public class Prob1168 {
	// Union Find solution
    // Intuition: - Have a priority queue (heap) that orders by cost.
    //            - add the values for wells to a "virtual" node 0 (zero).
    //            - run union until roots value is 1, everyone is connect.
    //
    // Why does it work? 
	//        As we have more unions than size and every time we pick the cheapest cost (either a pipe or well.)
	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if (n < 1) return 0;
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        for (int[] pipe : pipes) {
        	q.offer(pipe);
        }
        for (int i = 0; i < wells.length; i++) {
        	q.offer(new int[] {0, i + 1, wells[i]});
        }
        UnionFind uf = new UnionFind(n + 1);
        while(uf.roots > 1) {
        	int[] arr = q.poll();
        	uf.union(arr[0], arr[1], arr[2]);
        }
        return uf.totalCosts;
    }
	
	class UnionFind {
		private int[] parent, size;
		private int totalCosts;
		private int roots;
		UnionFind(int n) {
			roots = n;
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}
		
		int find(int i) {
			while(i != parent[i]) {
				i = parent[i];
			}
			return i;
		}
		
		void union(int i, int j, int cost) {
			int rootI = find(i);
			int rootJ = find(j);
			if (rootI == rootJ) return;
			totalCosts += cost;
			roots--;
			if (size[rootI] >= size[rootJ]) {
				parent[rootJ] = rootI;
				size[rootI] += size[rootJ];
			} else {
				parent[rootI] = rootJ;
				size[rootJ] += size[rootI];
			}
		}
		
	}
	/*public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // sum[i][j] is matrix sum till i -1, j - 1 th element starting from 0, 0
        int[][] sum = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		sum[i][j] = matrix[i - 1][j - 1] + sum[i][j - 1] 
        				+ sum[i - 1][j] - sum[i - 1][j - 1];
        		for (int x = 0; x < i; x++) {
        			int sumWithoutXRow = sum[i][j] - sum[x][j];
        			for (int y = 0; y < j; y++) {
        				int sumWithoutYCol = sumWithoutXRow - sum[i][y];
        				if (sumWithoutYCol + sum[x][y] == target) result++;
        			}
        		}
        	}
        }
        return result;
    }*/
}
