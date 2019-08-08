package com.leet.algo;
import java.util.*;
public class Prob324 {
	public void wiggleSort(int[] nums) {
        int n = nums.length;
        int mid = findKthLargest(nums, n / 2);
        /*int i = 1, j = n - 1;
        if (j % 2 == 1) j--;
        while (i < j) {
        	exchange(nums, i, j);
        	i += 2; j -= 2;
        }*/
        
        
        int l = 0, i = 0, r = nums.length - 1;
    	while (i <= r) {
    		if (mid < nums[mapIndex(i, n)]) {
    			exchange(nums, mapIndex(i++, n), mapIndex(l++, n));
    		} else if (mid > nums[mapIndex(i, n)]) {
    			exchange(nums, mapIndex(i, n), mapIndex(r--, n));
    		} else
    			i++;
    	}
    }
	
	private int mapIndex(int x, int n) {
		return (1 + 2 * x) % (n | 1);
	}
	
	private int findKthLargest(int[] nums, int k) {
		shuffle(nums);
		int l = 0, r = nums.length - 1;
		while (true) {
			int pivot = partition(nums, l, r);
			if (pivot > k) {
				r = pivot - 1;
			} else if (pivot < k) {
				l = pivot + 1;
			} else {
				return nums[pivot];
			}
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
	  
	  public static void main(String[] args) {
		  Prob324 prob = new Prob324();
		  //int[] arr = new int[] {1, 5, 1, 1, 6, 4};
		  int[] arr = new int[] {1,3,2,2,3,1};
		  prob.wiggleSort(arr);
		  System.out.println(arr);
	  }
}
