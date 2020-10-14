package comp.prep2019.less1000;

import java.util.*;

public class Prob719 {
	/**
	 * o(nlogn)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1];
        while(l < r) {
        	int mid = l + (r - l) / 2;
        	int count = countDiffLessEqualX(nums, mid);
        	// let say r = r1 where c = k.
        	// that does not mean the diff r1 is present in the array
        	// l moves 1 at a time
        	// which will ensure if r1 is not present and r1 -1 is present then 
        	//we get r1 - 1
        	if (count >= k) r = mid;
        	else l = mid + 1;
        }
        return l;
    }
	
	/**
	 * O(N)
	 * finds the count of diff <= x
	 * @param nums
	 * @param x
	 * @return
	 */
	private int countDiffLessEqualX(int[] nums, int x) {
		int l = 0;
		int result = 0;
		for (int r = l + 1; r < nums.length; r++) {
			while (nums[r] - nums[l] > x) l++;
			result += r - l;
		}
		return result;
	}
}
