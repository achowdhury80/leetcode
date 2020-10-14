package comp.prep2019.less1000;

public class Prob832 {
	/**
	 * O(N) time
	 * @param A
	 * @return
	 */
	public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
        	int j = 0, k = A[i].length - 1;
        	while(j < k) {
        		if (A[i][j] == A[i][k]) {
        			A[i][j] ^= 1;
        			A[i][k] ^= 1;
        		}
        		j++;
        		k--;
        	}
        	if (j == k) A[i][j] ^= 1;
        }
        return A;
    }
}
