package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/22/17.
 */
public class Prob368 {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    int n;
    List<Integer> result = new ArrayList<>();
    if(nums == null || (n = nums.length) < 1) return result;
    if(n == 1) {
      result.add(nums[0]);
      return result;
    }
    Arrays.sort(nums);
    List<Integer>[] dp = new List[n + 1];
    dp[0] = null;
    List<Integer> list = new ArrayList<>();
    list.add(nums[n - 1]);
    dp[n] = list;
    for(int i = n - 1; i > 0; i--){
      list = new ArrayList<>();
      list.add(nums[i - 1]);
      for(int j = i + 1; j < n + 1; j++){
        if(nums[j - 1] % nums[i - 1] != 0) continue;
        if(dp[j].size() > list.size() - 1){
          list.clear();
          list.add(nums[i - 1]);
          list.addAll(dp[j]);
        }
      }
      dp[i] = list;
    }
    for(int i = 1; i < n + 1; i++){
      if(dp[i].size() > result.size()){
        result = dp[i];
      }
    }
    return result;

  }

  public static void main(String[] args){
    Prob368 prob368 = new Prob368();
    //System.out.println(prob368.largestDivisibleSubset(new int[]{1,2,3}));
    //System.out.println(prob368.largestDivisibleSubset(new int[]{1,2,4, 8}));
    System.out.println(prob368.largestDivisibleSubset(new int[]{3,4,16,8}));

  }
}
