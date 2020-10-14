package comp.prep2019.less1000;
import java.util.*;
public class Prob493 {
	public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        return helper(nums, 0, nums.length - 1);
    }
	
	private int helper(int[] nums, int start, int end) {
		if (start >= end) return 0;
		int mid = start + (end - start) / 2;
		int result = 0;
		result += helper(nums, start, mid);
		result += helper(nums, mid + 1, end);
		for (int i = mid + 1; i <= end; i++) {
			if (2l * nums[i] > Integer.MAX_VALUE) continue;
			int valueToSearch = 0;
			if (2l * nums[i] < Integer.MIN_VALUE) valueToSearch = Integer.MIN_VALUE;
			else valueToSearch = 2 * nums[i];
			int insertIdx = Arrays.binarySearch(nums, start, mid + 1, valueToSearch);
			if (insertIdx >= 0) {
				while(insertIdx < mid && nums[insertIdx] == nums[insertIdx + 1]) 
					insertIdx++;
				result += mid - insertIdx;
			} else {
				insertIdx = - (insertIdx + 1);
				result += mid - insertIdx + 1;
			}
		}
		int[] merged = new int[end - start + 1];
		int i = start, j = mid + 1, idx = 0;
		while(i <= mid && j <= end) {
			if (nums[i] <= nums[j]) merged[idx++] = nums[i++];
			else merged[idx++] = nums[j++];
		}
		while(i <= mid) merged[idx++] = nums[i++];
		while(j <= end) merged[idx++] = nums[j++];
		for (i = 0; i < merged.length; i++) nums[start + i] = merged[i];
		return result;
	}
	
	public static void main(String[] args) {
		Prob493 prob = new Prob493();
		//System.out.println(prob.reversePairs(new int[] {1, 3, 2, 3, 1}));
		System.out.println(prob.reversePairs(new int[] {2147483647,2147483647,
				-2147483647,-2147483647,-2147483647,2147483647}));
	}
}
