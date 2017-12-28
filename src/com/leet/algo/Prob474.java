package com.leet.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/18/17.
 */
public class Prob474 {
  public int findMaxForm(String[] strs, int m, int n) {
    int len;
    if(strs == null || m < 0 || n < 0 || (len = strs.length) == 0) return 0;
    int[][][] dp = new int[m + 1][n + 1][len + 1];
    for(int j = 1; j <= len; j++){
      String st = strs[j - 1];
      int num1Count = IntStream.range(0, st.length()).map(x -> st.charAt(x) == '1' ? 1 : 0).filter(x -> x == 1).sum();
      int numZeroCount = st.length() - num1Count;
      for (int numZeros = 0; numZeros <= m; numZeros++){
        for(int numOnes = 0; numOnes <= n; numOnes++){
          if(numZeros == 0 && numOnes == 0) {
            dp[numZeros][numOnes][j] = 0;
          }
          dp[numZeros][numOnes][j] = dp[numZeros][numOnes][j - 1];
          if(num1Count <= numOnes && numZeroCount <= numZeros){
            dp[numZeros][numOnes][j] = Math.max(dp[numZeros][numOnes][j], dp[numZeros - numZeroCount][numOnes - num1Count][j - 1] + 1);
          }
        }
      }
    }
    return dp[m][n][len];
  }

  public static void main(String[] args){
    Prob474 prob474 = new Prob474();
    System.out.println(prob474.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    System.out.println(prob474.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    System.out.println(prob474.findMaxForm(new String[]{"10","0001","111001","1","0"}, 4, 3));
  }
}
