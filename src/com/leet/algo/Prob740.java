package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 12/19/17.
 */
public class Prob740 {
  public int deleteAndEarn(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int[] count = new int[10001];
    Arrays.stream(nums).forEach(x -> count[x] += x);
    int[] dp = new int[1003];
    for(int i = 10000; i >= 0; i--){
      dp[i] = Math.max(count[i] + dp[i -2], dp[i - 1]);
    }
    return dp[0];
//    Map<Integer, Integer> map = new HashMap<>();
//    Arrays.stream(nums).forEach(x -> map.put(x,map.getOrDefault(x, 0) + x));
//    List<Integer> list = new ArrayList<>(map.keySet());
//    Collections.sort(list);
//    int[] dp = new int[list.size()];
//    dp[0] = map.get(list.get(0));
//    if(list.size() > 1){
//      if(list.get(1) - 1 == list.get(0)){
//        dp[1] = map.get(list.get(1)) > dp[0] ? map.get(list.get(1)) : dp[0];
//      } else {
//        dp[1] = map.get(list.get(1)) + dp[0];
//      }
//    }
//    for(int i = 2; i < list.size(); i++){
//      if(list.get(i) - 1 == list.get(i - 1)){
//        if(map.get(list.get(i)) + dp[ i -2] > dp[i - 1]){
//          dp[i] = map.get(list.get(i)) + dp[ i -2];
//        } else dp[i] = dp[i - 1];
//      } else {
//        dp[i] = dp[i - 1] + map.get(list.get(i));
//      }
//    }
//    return dp[list.size() - 1];
  }

  public static void main(String[] args){
    Prob740 prob740 = new Prob740();
    System.out.println(prob740.deleteAndEarn(new int[]{3, 4, 2}));
    System.out.println(prob740.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
  }
}
