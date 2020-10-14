package comp.prep2019;

public class Prob413 {
	public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int result = 0;
        int last = 2;
        for (int i = 2; i < A.length; i++) {
        	if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        		last++;
        		if (last > 2) result += last - 2;
        	} else last = 2;
        }
        return result;
    }
}
