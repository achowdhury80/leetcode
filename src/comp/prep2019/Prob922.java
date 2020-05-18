package comp.prep2019;

public class Prob922 {
	/**
	 * O(N) & O(1)
	 * keep two pointer for even and odd which are not properly set
	 * keep swapping
	 * @param A
	 * @return
	 */
	public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1; // even and odd pointer
        while(i < A.length && j < A.length) {
        	while(i < A.length && A[i] % 2 == 0) {
            	i += 2;
            }
        	while(j < A.length && A[j] % 2 == 1) {
            	j += 2;
            }
        	if (j > A.length) return A;
        	int temp = A[i];
        	A[i] = A[j];
        	A[j] = temp;
        }
        return A;
    }
}
