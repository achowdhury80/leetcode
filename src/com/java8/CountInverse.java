package com.java8;

import java.util.Arrays;

/**
 * Created by ayanc on 11/29/17.
 */
public class CountInverse {

  public static void main(String[] args){
    int[] arr = new int[]{1, 3, 5, 2, 4, 6};
    int[] arr1 = Arrays.copyOf(arr, arr.length);
    CountInverse countInverse = new CountInverse();
    int count = countInverse.countInverse(arr1, 0, arr.length - 1);
    System.out.println(count);
  }

  public int countSplitInverse(int[] arr, int start, int mid, int end){
    int[] combined = new int[end - start + 1];
    int m = start;
    int n = mid + 1;
    int k = 0;
    int count = 0;
    while(m <= mid && n <= end){
      if(arr[m] > arr[n]){
        count += (mid - m) + 1;
        combined[k++] = arr[n++];
      } else {
        combined[k++] = arr[m++];
      }
    }
    while(m <= mid) combined[k++] = arr[m++];
    while(n <= end) combined[k++] = arr[n++];
    for(int i = 0; i < combined.length; i++){
      arr[start + i] = combined[i];
    }
    return count;
  }

  public int countInverse(int[] arr, int start, int end){
    if(end <= start) return 0;
    int mid = (start + end) / 2;
    int x = countInverse(arr, start, mid);
    int y = countInverse(arr, mid + 1, end);
    int z = countSplitInverse(arr, start, mid, end);
    return x + y + z;

  }
}
