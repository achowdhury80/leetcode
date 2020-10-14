package comp.prep2019;

import java.util.Arrays;

public class Prob805 {
	/**
	 * O(2^(n / 2)) time and space
	 * @param A
	 * @return
	 */
	public boolean splitArraySameAverage(int[] A) {
		Arrays.sort(A);
        int sum = 0;
        for (int a : A) sum += a;
        for (int i = 1; i <= A.length / 2; i++) {
        	if ((sum * i) % A.length == 0 
        			&& existsSubset(A, (sum * i) / A.length, i, 0)) return true;
        }
        return false;
    }
	
	private boolean existsSubset(int[] A, int target, int count, int startIndex) {
		if (count == 0) return target == 0;
		for (int i = startIndex; i < A.length - count + 1 && A[i] <= target; i++) {
			if (i > startIndex && A[i] == A[i - 1]) continue;
			if (existsSubset(A, target - A[i], count - 1, i + 1)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Prob805 prob = new Prob805();
		System.out.println(prob.splitArraySameAverage(new int[] {18, 0, 16, 2}));
		System.out.println(prob.splitArraySameAverage(new int[] {17, 3, 7, 12, 1}));
	}
}
