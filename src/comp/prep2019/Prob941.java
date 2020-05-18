package comp.prep2019;

public class Prob941 {
	public boolean validMountainArray(int[] A) {
        if (A.length < 3 || A[1] < A[0]) return false;
        boolean decrementStarted = false;
        int max = -1;
        for (int i = 1; i < A.length; i++) {
        	if (A[i] == A[i - 1]) return false;
        	if (max == -1) {
        		if (A[i] < A[i - 1]) return false;
        	}
        	if (decrementStarted) {
        		if (A[i] > A[i - 1]) return false;
        	}
        	if (A[i] > A[i - 1]) max = A[i];
        	else if (A[i] < A[i - 1]) decrementStarted = true;
        }
        return decrementStarted;
    }
}
