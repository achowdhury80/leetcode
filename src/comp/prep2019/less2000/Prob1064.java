package comp.prep2019.less2000;

public class Prob1064 {
	/**
	 * O(logN)
	 * @param A
	 * @return
	 */
	public int fixedPoint(int[] A) {
		int start = 0, end = A.length - 1;
        while(start < end) {
        	int mid = start + (end - start) / 2;
        	if (A[mid] == mid) {
        		end = mid; // you can find smaller
        	} else if (A[mid] > mid) { // then the answer on the left side
        		end = mid - 1;
        	} else { // then the answer on the right side
        		start = mid + 1;
        	}
        }
        // at this point start may be the answer
        return A[start] == start ? start : -1;
    }

}
