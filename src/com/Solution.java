package com;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 7/10/17.
 */
public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
    System.out.println(arr[0] + "," + arr[1]);
  }

  public int[] twoSum(int[] nums, int target) {
    if(nums == null || nums.length < 2) return null;
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
      if(map.containsKey(nums[i]) && nums[map.get(nums[i])] != nums[i]){
        return new int[]{map.get(nums[i]), i};
      } else {
        map.put(target - nums[i], i);
      }
    }
    return null;
  }

  }
