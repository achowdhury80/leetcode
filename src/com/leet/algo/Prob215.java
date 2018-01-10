package com.leet.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/9/18.
 */
public class Prob215 {
  public int findKthLargest(int[] nums, int k) {
    MaxHeap heap = new MaxHeap(nums.length);
    Arrays.stream(nums).forEach(x -> heap.add(x));
    IntStream.range(0, k - 1).forEach(x -> heap.remove());
    return heap.remove();

  }

  class MaxHeap {
    int n = 0;
    int[] arr = null;
    MaxHeap(int size){
      arr = new int[size];
    }

    public void add(int i){
      arr[n] = i;
      int k = n;
      n++;
      while (k > 0) {
        int parent = (k - 1) / 2;
        if (arr[parent] < arr[k]) {
          swap(parent, k);
          k = parent;
        } else break;
      }
    }
    private void swap(int i, int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    public int remove(){
      int result = arr[0];
      arr[0] = arr[n - 1];
      n--;
      int k = 0;
      while(k < n){
        int left = 2 * k + 1;
        int right = left + 1;
        if(left < n && right < n){
          int max = left;
          if(arr[max] < arr[right]) max = right;
          if(arr[k] > arr[max]) break;
          swap(k, max);
          k = max;
        } else if(left >= n && right >= n) break;
        else if(left < n){
          if(arr[k] > arr[left]) break;
          else {
            swap(k, left);
            k = left;
          }
        } else {
          if(arr[k] > arr[right]) break;
          else {
            swap(k, right);
            k = right;
          }
        }
      }
      return result;
    }
  }

  public static void main(String[] args){
    Prob215 prob215 = new Prob215();
    System.out.println(prob215.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
  }
}
