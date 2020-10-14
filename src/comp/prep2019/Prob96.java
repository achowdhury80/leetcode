package comp.prep2019;

import java.util.*;

public class Prob96 {
	/**
	 * O(N^2)
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		if (n < 1) return 0; 
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        return numTrees(n, arr);
    }
	
	public int numTrees(int n, int[] arr) {
        if (arr[n] != 0) return arr[n];
        int result = 0;
        for (int i = 1; i <= n; i++) {
        	result += numTrees(i - 1, arr) * numTrees(n - i, arr);
        }
        arr[n] = result;
        return result;
    }
	
	public static void main(String[] args) {
		Prob96 prob = new Prob96();
		System.out.println(prob.numTrees(3));
	}
}
