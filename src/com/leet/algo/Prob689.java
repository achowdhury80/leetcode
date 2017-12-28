package com.leet.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/21/17.
 */
public class Prob689 {
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int n;
    if(nums == null || k < 1 || (n = nums.length) == 0) return null;
    int[] sums = new int[n - k + 1];
    IntStream.range(0, k).forEach(x -> sums[0] += nums[x]);
    IntStream.range(1, sums.length).forEach(x -> sums[x] = sums[x - 1] - nums[x - 1] + nums[x + k - 1]);
    //Arrays.stream(sums).forEach(x -> System.out.print(x + ","));
    int[][][] dp = new int[n + 1][4][3];
    IntStream.range(0, dp.length).forEach(x ->{
      IntStream.range(0, 4).forEach(y -> {
        IntStream.range(0, 3).forEach(z -> dp[x][y][z] = -1);
      });
    });
    IntStream.range(1,4).forEach(x -> {
      IntStream.range(1, dp.length).forEach(y -> {
        if(y >= k * x){
          if(y == k * x){
            dp[y][x] = new int[]{-1, -1, -1};
            for(int i = 0; i < x; i++){
              dp[y][x][i] = i * k;
            }
          } else {
            dp[y][x] = betterOf(sums, dp[y - 1][x], merge(dp[y - k][x - 1], x - 1, y - k), x);
          }
        }
        //System.out.println("dp[" + y + "][" + x + "]: " + dp[y][x][0] + "," + dp[y][x][1] + ","+ dp[y][x][2]);
      });
    });
    return dp[n][3];
  }

  private int[] merge(int[] smallerDp, int numberOfElementsInFirstSet, int newSubsetStartingPosition){
    if(numberOfElementsInFirstSet > 0 && smallerDp[numberOfElementsInFirstSet - 1] == -1) return new int[]{-1, -1, -1};
    int[] newDp = Arrays.copyOf(smallerDp, 3);
    newDp[numberOfElementsInFirstSet] = newSubsetStartingPosition;
    return newDp;
  }

  private int[] betterOf(int[] sums, int[] indices1, int[] indices2, int numberOfSubset){
    int dp1Sum = subsetSum(sums, indices1, numberOfSubset);
    int dp2Sum = subsetSum(sums, indices2, numberOfSubset);
    if(dp1Sum == dp2Sum){
      StringBuilder sb1 = new StringBuilder();
      Arrays.stream(indices1).forEach(x -> sb1.append(x));
      StringBuilder sb2 = new StringBuilder();
      Arrays.stream(indices2).forEach(x -> sb2.append(x));
      return sb1.toString().compareTo(sb2.toString()) < 1 ? indices1 : indices2;
    } else return dp1Sum > dp2Sum ? indices1 : indices2;
  }

  private int subsetSum(int[] sums, int[] indices, int numberOfSubset){
    int sum = 0;
    for(int i = 0; i < numberOfSubset; i++){
      sum += sums[indices[i]];
    }
    return sum;
  }


  public static void main(String[] args){
    Prob689 prob689 = new Prob689();
    Arrays.stream(prob689.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2)).forEach(x -> System.out.print(x));
    Arrays.stream(prob689.maxSumOfThreeSubarrays(new int[]{18,11,14,7,16,4,18,11,4,8}, 2)).forEach(x -> System.out.print(x));
  }
}
