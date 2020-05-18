package comp.prep2019;

import java.util.Arrays;

public class Prob1196 {
	/**
	 * O(NlogN)
	 * sort the array. then add apples
	 * @param arr
	 * @return
	 */
	public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int count = 0, idx = 0;
        while(idx < arr.length) {
        	count += arr[idx];
        	if (count > 5000) {
        		return idx;
        	}
        	idx++;
        }
        return idx;
    }
}
