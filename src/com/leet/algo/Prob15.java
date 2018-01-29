package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 1/24/18.
 */
public class Prob15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || nums.length < 3) return result;
    Arrays.sort(nums);
    for(int i = 0; i < nums.length; i++){
      if(i > 0 && nums[i] == nums[i - 1]) continue;
      int low = i + 1;
      int high = nums.length - 1;
      while (low < high){
        if (0l + nums[i] + nums[low] + nums[high] > 0) {
          high--;
        } else if (0l + nums[i] + nums[low] + nums[high] < 0) {
          low++;
        } else {
          result.add(Arrays.asList(nums[i], nums[low], nums[high]));
          while(low < high && nums[low] == nums[low + 1]) low++;
          while(low < high && nums[high - 1] == nums[high]) high--;
          low++;
          high--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob15 prob15 = new Prob15();
    System.out.println(prob15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }
}
