package comp.prep2019;

import java.util.Random;

public class Prob215 {
	public int findKthLargest(int[] nums, int k) {
	    shuffle(nums);
	    k = nums.length - k;
	    int lower = 0;
	    int higher = nums.length - 1;
	    while (true) {
	      int i = partition(nums, lower, higher);
	      if (i == k) return nums[k];
	      if (i > k) higher = i - 1;
	      else lower = i + 1;
	    }
	  }

	  private int partition(int[] arr, int low, int high) {
	    if (low == high) return low;
	    int pivot = arr[low];
	    int i = low, j = low;
	    while (j < high) {
	      j++;
	      if (arr[j] <= pivot) {
	        i++;
	        exchange(arr, i, j);
	      }
	    }
	    exchange(arr, low, i);
	    return i;
	  }

	  private void shuffle(int[] arr) {
	    Random random = new Random();
	    for (int i = 1; i < arr.length; i++) {
	      int r = random.nextInt(i + 1);
	      exchange(arr, i, r);
	    }
	  }

	  private void exchange(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }
}
