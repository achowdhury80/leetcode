package com.java8;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ayanc on 11/29/17.
 */
public class QuickSort {

  public static void main(String[] args){
    int[] arr = new int[]{3, 8, 2, 5, 1, 4, 7, 6};
    QuickSort quickSort = new QuickSort();
    quickSort.sort(arr, 0, arr.length - 1);
    Arrays.stream(arr).forEach(System.out::print);
  }

  public int partition(int[] arr, int start, int end){
    int i = start;
    for(int j = start + 1; j <= end; j++){
      if(arr[j] < arr[start]){
        i += 1;
        swap(arr, i, j);
      }
    }
    swap(arr, start, i);
    return i;

  }

  public void sort(int[] arr, int start, int end){
    if(end <= start) return;
    int pivotIndex = start + new Random().nextInt(end - start + 1);
    swap(arr, start, pivotIndex);
    pivotIndex = partition(arr, start, end);
    sort(arr, start, pivotIndex - 1);
    sort(arr, pivotIndex + 1, end);

  }

  private void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void print(int[] arr, int start, int end){
    for(int i = start; i <= end; i++) System.out.print(arr[i] + ",");
    System.out.println();
  }
}
