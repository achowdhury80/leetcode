package com.java8;

import java.util.Arrays;

/**
 * Created by ayanc on 11/29/17.
 */
public class MergeSort {

  public static void main(String[] args){
    int[] arr = new int[]{5,4,1, 8, 7, 2, 6, 3};
    MergeSort mergeSort = new MergeSort();
    mergeSort.sort(arr, 0, arr.length - 1);
    Arrays.stream(arr).forEach(System.out::print);
  }

  public void mergeSort(int[] arr, int start, int mid, int end){
    int[] combined = new int[end -start + 1];
    int m = start;
    int n = mid + 1;
    int k = 0;
    while(m <= mid && n <= end){
      combined[k++] = arr[m] > arr[n] ? arr[n++] : arr[m++];
    }
    while(m <= mid) combined[k++] = arr[m++];
    while(n <= end) combined[k++] = arr[n++];
    for(int i = 0; i < combined.length; i++){
      arr[start + i] = combined[i];
    }

  }

  public void sort(int[] arr, int start, int end){
    if(end <= start) return;
    int mid = (start + end) / 2;
    sort(arr, start, mid);
    sort(arr, mid + 1, end);
    mergeSort(arr, start, mid, end);

  }
}
