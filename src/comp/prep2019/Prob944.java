package comp.prep2019;

public class Prob944 {
	/**
	 * O(m*N)
	 * @param A
	 * @return
	 */
	public int minDeletionSize(String[] A) {
        int result = 0;
        for (int i = 0; i < A[0].length(); i++) {
        	char last = 'a';
        	for (int j = 0; j < A.length; j++) {
        		if (A[j].charAt(i) < last) {
        			result++;
        			break;
        		}
        		last = A[j].charAt(i);
        	}
        }
        return result;
    }
}
