package comp.prep2019.less1000;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prob912 {
	/**
	 * O(NlogN)
	 * @param nums
	 * @return
	 */
	public List<Integer> sortArray(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        List<Integer> result = new ArrayList<>();
        for (int num : nums) result.add(num);
        return result;
    }
	
	private void sort(int[] nums, int start, int end) {
		int pivot = partition(nums, start, end);;
		if (pivot > start + 1) sort(nums, start, pivot - 1);
		if(pivot < end - 1) sort(nums, pivot + 1, end);
	}
	
	private int partition(int[] arr, int start, int end) {
		int i = start + 1, lower = start, pivot = start;
		while(i <= end) {
			if (arr[i] <= arr[pivot]) {
				swap(arr, ++lower, i);
			}
			i++;
		}
		swap(arr, pivot, lower);
		return lower;
	}
	
	private void shuffle(int[] nums) {
		Random random = new Random();
		for (int i = 1; i < nums.length; i++) {
			int j = random.nextInt(i);
			swap(nums, i, j);
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
