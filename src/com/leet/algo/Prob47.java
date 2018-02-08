package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob47 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || nums.length < 1) return result;
    Arrays.sort(nums);
    boolean[] used = new boolean[nums.length];
    dfs(result, nums, used, new ArrayList<>());
    return result;
  }

  public void dfs(List<List<Integer>> lists, int[] nums, boolean[] used, List<Integer> list) {
    if (list.size() == nums.length) {
      lists.add(new ArrayList<>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) continue;
      if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
      used[i] = true;
      list.add(nums[i]);
      dfs(lists, nums, used, list);
      used[i] = false;
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args){
    Prob47 prob47 = new Prob47();
    //System.out.println(prob47.permuteUnique(new int[]{1,1,2}));
    System.out.println(prob47.permuteUnique(new int[]{2,2,1,1}));
  }
}
