package comp.prep2019.less2000;

public class Prob1089 {
	/**
	 * O(N) time and O(1) space
	 * @param arr
	 */
	public void duplicateZeros(int[] arr) {
        int last = arr.length - 1, cur = 0;
        int idx = arr.length - 1;
        while(cur < last) {
        	if (arr[cur] == 0) {
        		last--;
        	} 
        	// if cur = last - 1, then the last element will be added to the end.
        	// if it is zero, it will not be doubled
        	// decrement last
        	if (cur == last - 1) {
        		arr[idx--] = arr[last];
        		last--;
        		break;
        	}
        	cur++;
        }
        // start from last, put two zeors for each zero
        for (int i = last; i > -1; i--) {
        	if (arr[i] == 0) {
        		arr[idx--] = 0;
        		arr[idx--] = 0;
        	} else {
        		arr[idx--] = arr[i];
        	}
        }
    }
}
