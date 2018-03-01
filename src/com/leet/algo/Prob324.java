package com.leet.algo;

import java.util.Random;

/**
 * Created by ayanc on 2/21/18.
 */
public class Prob324 {
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length < 2) return;
    if (nums.length == 2) {
      if (nums[0] > nums[1]) swap(nums, 0, 1);
      return;
    }
    shuffle(nums);
    int medianIdx = nums.length / 2 ;
    int median = findKthElement(nums, medianIdx);
    int i = 2;
    int j = (medianIdx % 2 == 0 ? medianIdx + 2 : medianIdx + 1);
    while (i < medianIdx && j < nums.length) {
      swap(nums, i, j);
      i += 2;
      i += 2;
    }
  }

  private void shuffle(int[] num) {
    Random random = new Random();
    for (int i = 1; i < num.length; i++){
      int r = random.nextInt(i + 1);
      swap(num, i, r);
    }
  }

  private int findKthElement(int[] num, int k) {
    int low = 0;
    int high = num.length - 1;
    while (true) {
      int pivot = partition(num, low, high);
      if (pivot == k) return num[k];
      if (pivot > k) high = pivot - 1;
      else low = pivot + 1;
    }

  }

  private int partition(int[] num, int low, int high) {
    int pivotVal = num[low];
    int i = low, j = low;
    while (j < high) {
      j++;
      if (num[j] <= pivotVal) {
        i++;
        swap(num, i, j);
      }
    }
    swap(num, low, i);
    return i;
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    Prob324 prob324 = new Prob324();
    int[] arr;
    arr = new int[]{1, 5, 1, 1, 6, 4};
    prob324.wiggleSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println();
  }
}
