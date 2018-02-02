package com.leet.algo;

/**
 * Created by ayanc on 1/29/18.
 */
public class Prob307 {
  int[] segmentTree;
  int n;
  public Prob307(int[] nums) {
    if(nums == null || nums.length < 1) return;
    n = nums.length;
    int segmentTreeLength = 1;
    while (segmentTreeLength < n){
      segmentTreeLength *= 2;
    }
    segmentTree = new int[segmentTreeLength * 2 - 1];
    populate(nums, 0, n - 1, 0);
  }

  public void update(int i, int val) {
    update(0, n - 1, i, val, 0);
  }

  public void update(int low, int high, int i, int val, int pos) {
    if (i < low || i > high) return;
    if (i == low && low == high) {
      segmentTree[pos] = val;
    } else {
      int mid = (low + high) / 2;
      update(low, mid, i, val, 2 * pos + 1);
      update(mid + 1, high, i, val, 2 * pos + 2);
      segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }
  }

  public int sumRange(int i, int j) {
    return sumRange(0, n - 1, i, j, 0);
  }

  private int sumRange(int low, int high, int i, int j, int pos){
    if(i > high || j < low) return 0;
    if(low >= i && high <= j) return segmentTree[pos];
    int mid = (low + high) / 2;
    return sumRange(low, mid, i, j, 2 * pos + 1) + sumRange(mid + 1, high, i, j, 2 * pos + 2);
  }

  private void populate(int[] nums, int low, int high, int pos){
    if(low == high){
      segmentTree[pos] = nums[low];
      return;
    }
    int mid = (low + high) / 2;
    populate(nums, low, mid, 2 * pos + 1);
    populate(nums, mid + 1, high, 2 * pos + 2);
    segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
  }

  public static void main(String[] args){
    Prob307 prob307 = new Prob307(new int[]{1, 3, 5});
    //Prob307 prob307 = new Prob307(new int[]{-1, 3, 4, 0, 2, 1});
    //System.out.println(prob307.sumRange(0, 4));
    System.out.println(prob307.sumRange(0, 2));
    prob307.update(1, 2);
    System.out.println(prob307.sumRange(0, 2));
  }

}
