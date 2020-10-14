package comp.prep2019;

import java.util.Random;

public class Prob215 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
	    shuffle(nums);
	    k = nums.length - k;
	    int start = 0, end = nums.length - 1;
	    while(true) {
	    	int rank = partition(nums, start, end);
	    	if (rank == k) return nums[rank];
	    	if (rank < k) start = rank + 1;
	    	else end = rank - 1;
	    }
	  }

	  private int partition(int[] nums, int start, int end) {
		  int pivot = nums[start];
		  int left = start;
		  for (int i = start + 1; i <= end; i++) {
			  if (nums[i] <= pivot) {
				 exchange(nums, ++left, i);
			  }
		  }
		  exchange(nums, start, left);
		  return left;
	  }

	  private void shuffle(int[] arr) {
	    Random random = new Random();
	    for (int i = 1; i < arr.length; i++) {
	    	int idx = random.nextInt(i + 1);
	    	exchange(arr, i, idx);
	    }
	  }

	  private void exchange(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }
}
