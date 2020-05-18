package comp.prep2019;

public class Prob413 {
	public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int result = 0;
        int last = 2;
        for (int i = 2; i < A.length; i++) {
        	if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        		int count = last - 1;
        		result += count;
        		last++;
        	} else {
        		last = 2;
        	}
        }
        return result;
    }
}
