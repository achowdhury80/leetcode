package comp.prep2019.less1000;

public class Prob795 {
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		int start = -1, found = -1;
		int result = 0;
		for (int i = 0; i < A.length; i++) {
        	if (A[i] < L) {
        		if (start == -1) start = i;
        		if (found > -1) {
        			result += (i - start + 1) - (i - found);
        		}
        	} else if (A[i] >= L && A[i] <= R) {
        		found = i;
        		if (start == -1) start = i;
        		result += (i - start + 1);
        	} else {
        		found = -1;
        		start = -1;
        	}
        }
		return result;
    }
}
