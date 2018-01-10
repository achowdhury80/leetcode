package com.leet.algo;

/**
 * Created by ayanc on 1/9/18.
 */
public class Prob378 {
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    MinHeap heap = new MinHeap(n * n);
    for(int i = 0; i < n; i++)
      for(int j = 0; j < n; j++)
        heap.add(matrix[i][j]);
    for(int i = 0; i < k - 1; i++) heap.remove();
    return heap.remove();
  }

  class MinHeap {
    int n = 0;
    int[] arr = null;
    MinHeap(int size){
      arr = new int[size];
    }

    public void add(int i){
      arr[n] = i;
      int k = n;
      n++;
      while (k > 0) {
        int parent = (k - 1) / 2;
        if (arr[parent] > arr[k]) {
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
          int min = left;
          if(arr[min] > arr[right]) min = right;
          if(arr[k] < arr[min]) break;
          swap(k, min);
          k = min;
        } else if(left >= n && right >= n) break;
        else if(left < n){
          if(arr[k] < arr[left]) break;
          else {
            swap(k, left);
            k = left;
          }
        } else {
          if(arr[k] < arr[right]) break;
          else {
            swap(k, right);
            k = right;
          }
        }
      }
      return result;
    }
  }
}
