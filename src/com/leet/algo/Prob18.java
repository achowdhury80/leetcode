package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 1/24/18.
 */
public class Prob18 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || (n = nums.length) < 4) return result;
    Arrays.sort(nums);
    int max = nums[n - 1];
    if((0l + nums[0]) * 4 > target || (0l + max) * 4 < target) return result;
    for(int i = 0; i < n - 3; i++){
      int z = nums[i];
      if (i > 0 && nums[i - 1] == z || (0l + z + 3 * max) < target) continue;
      if(4 * z > target) break;
      if(4 * z == target){
        if(i + 3 < n && z == nums[i + 3]) result.add(Arrays.asList(z, z, z, z));
        break;
      }
      result.addAll(threeSumForFour(nums, i + 1, target - z, nums[i]));
    }
    return result;
  }

  private List<List<Integer>> threeSumForFour(int[] nums, int start, int target, int x){
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    int max = nums[n - 1];
    if((0l + nums[start]) * 3 > target || (0l + max) * 3 < target) return result;
    for(int i = start; i < n - 2; i++){
      int z = nums[i];
      if (i > start && nums[i - 1] == z || (0l + z + 2 * max) < target) continue;
      if(3 * z > target) break;
      if(3 * z == target){
        if(i + 2 < n && z == nums[i + 2]) result.add(Arrays.asList(x, z, z, z));
        break;
      }
      result.addAll(twoSumForFour(nums, i + 1, target - z, x, nums[i]));
    }
    return result;
  }

  private List<List<Integer>> twoSumForFour(int[] nums, int start, int target, int x, int y) {
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    int max = nums[n - 1];
    if((0l + nums[start]) * 2 > target || (0l + max) * 2 < target) return result;
    int low = start, high = n - 1;
    while(low < high){
      int sum = nums[low] + nums[high];
      if(sum == target) {
        result.add(Arrays.asList(x, y, nums[low], nums[high]));
        int k = nums[low];
        while(++low < high && nums[low] == k);
        k = nums[high];
        while(low < --high && nums[high] == k);
      } else if(sum > target) high--;
      else low++;
    }
    return result;
  }

  public static void main(String[] args){
    Prob18 prob18 = new Prob18();
    System.out.println(prob18.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    System.out.println(prob18.fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
  }
}
