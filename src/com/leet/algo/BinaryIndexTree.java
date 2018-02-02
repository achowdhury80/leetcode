package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/1/18.
 */
public class BinaryIndexTree {
  int[] data;
  private BinaryIndexTree(){

  }

  private void construct(int[] nums){
    data = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++){
      data[i + 1] += nums[i];
      int j = findNextPosition(i + 1);
      while (j < data.length){
        data[j] += nums[i];
        j = findNextPosition(j);
      }
    }
    //IntStream.range(0, nums.length + 1).forEach(idx -> System.out.print(data[idx] + ","));
  }

  private void showData() {
    IntStream.range(0, data.length).forEach(idx -> System.out.print(data[idx] + ","));
  }

  static BinaryIndexTree createTree(int[] nums){
    BinaryIndexTree binaryIndexTree = new BinaryIndexTree();
    binaryIndexTree.construct(nums);
    return binaryIndexTree;
  }

  private int findNextPosition(int i) {
    return (i & (~i + 1)) + i;
  }

  private int findParent(int i) {
    return i == 0 ? 0 : (i -  (i & (~i + 1)));
  }

  public int findRangeSum(int lowIndex, int highIndex) {
    return findSum(highIndex) - (lowIndex == 0 ? 0 : findSum(lowIndex - 1));
  }

  private int findSum(int highIndex) {
    if (highIndex < 0) return 0;
    int sum = 0;
    int index = highIndex + 1;
    while (index != 0) {
      sum += data[index];
      index = findParent(index);
    }
    return sum;
  }

  public void incrementBy(int index, int val) {
    data[index + 1] += val;
    int j = findNextPosition(index + 1);
    while (j < data.length){
      data[j] += val;
      j = findNextPosition(j);
    }
  }

  public static void main(String[] args){
    BinaryIndexTree binaryIndexTree = BinaryIndexTree.createTree(new int[]{3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3});
    System.out.println(binaryIndexTree.findRangeSum(0, 5));
    System.out.println(binaryIndexTree.findRangeSum(0, 9));
    System.out.println(binaryIndexTree.findRangeSum(0, 6));
    System.out.println(binaryIndexTree.findRangeSum(4, 9));
    binaryIndexTree.incrementBy(3, 3);
    binaryIndexTree.showData();
  }


}
