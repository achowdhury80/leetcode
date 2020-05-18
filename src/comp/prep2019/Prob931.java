package comp.prep2019;

public class Prob931 {
	public int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; i++) {
        	for (int j = 0; j < A[0].length; j++) {
        		A[i][j] += findMin(A[i - 1], j - 1, j + 1);
        	}
        }
        return findMin(A[A.length - 1], 0, A[0].length - 1);
    }
	
	private int findMin(int[] A, int start, int end) {
		if (start < 0) start = 0;
		int result = A[start];
		for (int i = start + 1; i <= Math.min(A.length -1, end) ; i++) result = Math.min(result, A[i]);
		return result;
	}
}
