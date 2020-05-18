package comp.prep2019;

public class Prob977 {
	/**
	 * O(N) time
	 * @param A
	 * @return
	 */
	public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int i = 0, j = A.length - 1;
        int idx = A.length - 1;
        while(i <= j) {
        	if (Math.abs(A[i]) >= Math.abs(A[j])) {
        		result[idx--] = A[i] * A[i];
        		i++;
        	} else {
        		result[idx--] = A[j] * A[j];
        		j--;
        	}
        }
        return result;
    }
}
