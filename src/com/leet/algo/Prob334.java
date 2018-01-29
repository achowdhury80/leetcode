package com.leet.algo;

/**
 * Created by ayanc on 1/24/18.
 */
public class Prob334 {
  public boolean increasingTriplet(int[] nums) {
    if(nums == null || nums.length < 3) return false;
    Integer[] two = new Integer[2];
    two[0] = nums[0];
    for(int i = 1; i < nums.length; i++){
      if(two[1] != null){
        if(nums[i] > two[1]) return true;
        if(nums[i] == two[1]) continue;
        if(nums[i] < two[1] && nums[i] > two[0]){
          two[1] = nums[i];
        } else {
          two[0] = nums[i];
        }
      } else {
        if(nums[i] == two[0]) continue;
        if(nums[i] > two[0]) two[1] = nums[i];
        if(nums[i] < two[0]) two[0] = nums[i];
      }
    }
    return false;
  }

  public static void main(String[] args){
    Prob334 prob334 = new Prob334();
    System.out.println(prob334.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
    System.out.println(prob334.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
  }
}
