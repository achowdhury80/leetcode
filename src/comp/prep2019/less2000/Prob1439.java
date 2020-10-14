package comp.prep2019.less2000;
import java.util.*;
public class Prob1439 {
	/*
	 * solve it for two and then iterate
	 * o(k) space
	 * o(m * k * k * log(K))
	 */
	public int kthSmallest(int[][] mat, int k) {
        int[] arr = new int[Math.min(mat[0].length, k)];
        for (int i = 0; i < arr.length; i++) arr[i] = mat[0][i];
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x); 
        for (int i = 1; i < mat.length; i++) {
        	for(int j = 0; j < arr.length; j++) {
	        	for (int x = 0; x < Math.min(mat[i].length, k); x++) {
	        		q.offer(arr[j] + mat[i][x]);
	        		if (q.size() > k) q.poll();
	        	}
        	}
        	arr = new int[q.size()];
        	for (int l = arr.length - 1; l > -1; l--) arr[l] = q.poll();
        }
        return arr[k - 1];
    }
	
	public static void main(String[] args) {
		Prob1439 prob = new Prob1439();
		System.out.println(prob.kthSmallest(new int[][] {{1, 3, 11}, {2, 4, 6}}, 5));
	}
}
