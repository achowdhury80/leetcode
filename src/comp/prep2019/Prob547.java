package comp.prep2019;
import java.util.*;
public class Prob547 {
	public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        for (int i = 0; i < n - 1; i++) {
        	for (int j = i + 1; j < n; j++) {
        		if (M[i][j] == 1) {
        			int parentI = findParent(arr, i);
        			int parentj = findParent(arr, j);
        			int min = Math.min(parentI, parentj);
        			arr[parentI] = min;
        			arr[parentj] = min;
        		}
        	}
        }
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(findParent(arr, num));
        return set.size();
    }
	
	private int findParent(int[] arr, int i) {
		if(arr[i] == i) return i;
		return findParent(arr, arr[i]);
	}
	
	public static void main(String[] args) {
		Prob547 prob = new Prob547();
		int[][] M = new int[][] {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		System.out.println(prob.findCircleNum(M));
				
	}
}
