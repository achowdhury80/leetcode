package comp.prep2019.less1000;

import java.util.Arrays;
import java.util.*;
public class Prob996 {
	public int numSquarefulPerms(int[] A) {
        if (A.length < 2) return 0;
        Arrays.sort(A);
        boolean[] used = new boolean[A.length];
        int[] result = new int[1];
        helper(A, used, new ArrayList<>(), result);
        return result[0];
    }
	
	private void helper(int[] arr, boolean[] used, List<Integer> indices, int[] result) {
		if (indices.size() == arr.length) {
			result[0]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])) continue;
			if (indices.size() > 0 && !isSumPerfectSquare(
					arr[indices.get(indices.size() - 1)], arr[i])) continue;
			used[i] = true;
			indices.add(i);
			helper(arr, used, indices, result);
			used[i] = false;
			indices.remove(indices.size() - 1);
		}
	}
	
	private boolean isSumPerfectSquare(int a, int b) {
		int val = (int)Math.sqrt(a + b);
		return val * val == (a + b); 
	}
	
	public static void main(String[] args) {
		Prob996 prob = new Prob996();
		System.out.println(prob.numSquarefulPerms(new int[] {1, 17, 8}));
	}
}
