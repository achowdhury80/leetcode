package com.leet.algo;

/**
 * Created by ayanc on 1/9/18.
 */
public class Prob295 {
  private MaxHeap maxHeap;
  private MinHeap minHeap;
  int maxHeapSize;
  int minHeapSize;
  public Prob295() {
    maxHeap = new MaxHeap(10000);
    minHeap = new MinHeap(10000);
  }

  public void addNum(int num) {
    if(maxHeapSize + minHeapSize < 2){
      maxHeap.add(num);
      maxHeapSize++;
      adjustHeaps();
    } else {
      if(num < maxHeap.peek()){
        maxHeap.add(num);
        maxHeapSize++;
        adjustHeaps();
      } else {
        minHeap.add(num);
        minHeapSize++;
        adjustHeaps();
      }
    }
  }

  private void adjustHeaps(){
    while (Math.abs(maxHeapSize - minHeapSize) > 1){
      if(maxHeapSize > minHeapSize){
        minHeap.add(maxHeap.remove());
        minHeapSize++;
        maxHeapSize--;
      } else {
        maxHeap.add(minHeap.remove());
        maxHeapSize++;
        minHeapSize--;
      }
    }
  }

  public double findMedian() {
    if(maxHeapSize > minHeapSize) return maxHeap.peek();
    else if (minHeapSize > maxHeapSize) return minHeap.peek();
    else return (0.0 + maxHeap.peek() + minHeap.peek()) / 2;
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
    public int peek(){
      return arr[0];
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

    public int peek(){
      return arr[0];
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

  public static void main(String[] args){
    Prob295 prob295 = new Prob295();
    prob295.addNum(1);
    prob295.addNum(2);
    System.out.println(prob295.findMedian());
    prob295.addNum(3);
    System.out.println(prob295.findMedian());
  }
}
