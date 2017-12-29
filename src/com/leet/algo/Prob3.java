package com.leet.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob3 {
  public int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() < 1) return 0;
    if(s.length() == 1) return 1;
    int result = 0;
    int[] dp = new int[256];
    for(int i = 0, j = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(dp[c] > 0){
        j = Math.max(j, dp[c]);
      }
      dp[c] = i + 1;
      result = Math.max(result, i - j + 1);
    }
    return result;
  }
}
