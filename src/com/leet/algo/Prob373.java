package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/9/18.
 */
public class Prob373 {
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<int[]> result = new ArrayList<>();
    if(nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) return result;
    MinHeap minHeap = new MinHeap(nums1.length * nums2.length);
    for(int i = 0; i < nums1.length; i++){
      for(int j = 0; j < nums2.length; j++){
        minHeap.add(new Info(nums1[i], nums2[j]));
      }
    }

    for(int i = 0; i < k && i < nums1.length * nums2.length; i++){
      Info info = minHeap.remove();
      result.add(new int[]{info.first, info.second});
    }
    return result;
  }

  class MinHeap {
    int n = 0;
    Info[] arr = null;
    MinHeap(int size){
      arr = new Info[size];
    }

    public void add(Info info){
      arr[n] = info;
      int k = n;
      n++;
      while (k > 0) {
        int parent = (k - 1) / 2;
        if (arr[parent].sum() > arr[k].sum()) {
          swap(parent, k);
          k = parent;
        } else break;
      }
    }
    private void swap(int i, int j){
      Info temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    public Info peek(){
      return arr[0];
    }

    public Info remove(){
      Info result = arr[0];
      arr[0] = arr[n - 1];
      n--;
      int k = 0;
      while(k < n){
        int left = 2 * k + 1;
        int right = left + 1;
        if(left < n && right < n){
          int min = left;
          if(arr[min].sum() > arr[right].sum()) min = right;
          if(arr[k].sum() < arr[min].sum()) break;
          swap(k, min);
          k = min;
        } else if(left >= n && right >= n) break;
        else if(left < n){
          if(arr[k].sum() < arr[left].sum()) break;
          else {
            swap(k, left);
            k = left;
          }
        } else {
          if(arr[k].sum() < arr[right].sum()) break;
          else {
            swap(k, right);
            k = right;
          }
        }
      }
      return result;
    }
  }
  class Info {
    int first, second;
    Info(int first, int second){
      this.first = first;
      this.second = second;
    }
    int sum(){
      return first + second;
    }
  }
}
