package comp.prep2019.less1000;

public class Prob896 {
	public boolean isMonotonic(int[] A) {
        Boolean incresing = null;
        for (int i = 1; i < A.length; i++) {
        	if (A[i] > A[i - 1]) {
        		if (incresing != null && !incresing) return false;
        		incresing = true;
        	} else if(A[i] < A[i - 1]) {
        		if (incresing != null && incresing) return false;
        		incresing = false;
        	}
        }
        return true;
    }
}
