package comp.prep2019;
import java.util.*;
public class Prob480 {
	public double[] medianSlidingWindow(int[] nums, int k) {
		int n = nums.length;
        double[] result = new double[n - k + 1];
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	int loc = Collections.binarySearch(list, nums[i]);
        	if (loc > -1) {
        		list.add(loc + 1, nums[i]);
        	} else {
        		loc = -(loc + 1);
        		list.add(loc, nums[i]);
        	}
        	if (i < k - 1) continue;
        	if (i >= k) {
        		loc = Collections.binarySearch(list, nums[i - k]);
        		list.remove(loc);
        	}
        	result[idx++] = k % 2 == 1 ? list.get(k / 2) 
        			: (0.0 + list.get((k - 1) / 2) + list.get(k / 2)) / 2;
        }
        return result;
    }
}
