package com.leet.algo;

/**
 * Created by ayanc on 12/15/17.
 */
public class Prob300 {
  public int lengthOfLIS(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    if(nums.length == 1) return 1;
    int n = nums.length;
    int[] tailTable = new int[nums.length + 1];
    tailTable[0] = nums[0];
    int nextSlot = 1;
    for(int i = 1; i < nums.length; i++){
      if(nums[i] < tailTable[0]){
        tailTable[0] = nums[i];
      } else if(nums[i] > tailTable[nextSlot - 1]){
        tailTable[nextSlot++] = nums[i];
      } else {
        tailTable[findCeilIndex(tailTable, nums[i], 0, nextSlot - 1)] = nums[i];
      }
    }
    return nextSlot;

  }

  private int findCeilIndex(int[] tailTable, int nextNumber, int startingSlot, int endSlot){
    while(endSlot - startingSlot > 0){
      int mid = (startingSlot + endSlot) / 2;
      if(tailTable[mid] == nextNumber) return mid;
      if(tailTable[mid] > nextNumber){
        endSlot = mid;
      } else {
        startingSlot = mid + 1;
      }
    }
    return startingSlot;
  }




  public static void main(String[] args){
    Prob300 prob300 = new Prob300();
    //System.out.println(prob300.lengthOfLIS(new int[]{10, 9, 301, 302, 303, 304, 305, 201, 202, 203, 2, 5, 3, 7, 101, 18}));
    System.out.println(prob300.lengthOfLIS(new int[]{10,9,2,5,3,4}));
  }
}
