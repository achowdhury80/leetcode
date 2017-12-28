package com.leet.algo;

/**
 * given an array and a value, remove all instances of that value in place and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 Example:
 Given input array nums = [3,2,2,3], val = 3

 Your function should return length = 2, with the first two elements of nums being 2.

 */
public class RemoveNResizeArr {
  public int removeElement(int[] nums, int val) {
    if(nums == null || nums.length < 1) return 0;
    int length = nums.length;
    int i = 0;
    while (i < length){
      if(nums[i] != val) i++;
      else {
        while (nums[i] == val && i < length) {
          nums[i] = nums[--length];
        }
        i++;
      }
    }
    return length;
  }

  public static void main(String[] args){
    RemoveNResizeArr removeNResizeArr = new RemoveNResizeArr();
    int[] nums = new int[]{};
    for(int i = 0; i < nums.length; i++){
      System.out.print("," + nums[i]);
    }
    System.out.println();
    int newLength = removeNResizeArr.removeElement(nums, 3);
    for(int i = 0; i < newLength; i++){
      System.out.print("," + nums[i]);
    }
  }
}
