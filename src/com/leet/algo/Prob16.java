package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/24/18.
 */
public class Prob16 {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    Long closest = null;
    for (int i = 0; i < nums.length - 2; i++){
      int high = nums.length - 1;
      int low = i + 1;
      while (low < high){
        long sum = 0l + nums[i] + nums[low] + nums[high];
        if(sum == target) return target;
        if(closest == null) {
          closest = sum;
          if(sum > target) high--;
          else low++;
        }
        else {
          if (Math.abs(sum - target) >= Math.abs(closest - target)){
            if(sum > target) high--;
            else low++;
          } else {
            closest = sum;
            if(sum > target) high--;
            else low++;
          }
        }
      }
    }
    return Long.valueOf(closest).intValue();
  }

  public static void main(String[] args){
    Prob16 prob16 = new Prob16();
    System.out.println(prob16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    System.out.println(prob16.threeSumClosest(new int[]{13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,
        20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,
        -13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,
        19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6}, -59));

  }
}
