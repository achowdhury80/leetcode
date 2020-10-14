package comp.prep2019.less2000;

public class Prob1085 {
	/**
	 * O(N) time
	 * @param A
	 * @return
	 */
	public int sumOfDigits(int[] A) {
		if(A == null || A.length < 0) return 1;
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
        	min = Math.min(min, A[i]);
        }
        int sum = 0;
        while(min > 0) {
        	sum += min % 10;
        	min /= 10;
        }
        return sum % 2 == 1 ? 0 : 1;
    }
}
