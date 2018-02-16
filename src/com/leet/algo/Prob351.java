package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/13/18.
 */
public class Prob351 {
  public int numberOfPatterns(int m, int n) {
    List<List<Integer>>[] dp = new List[n];
    dp[0] = new ArrayList<>();
    IntStream.range(1, 10).forEach(num -> {
      dp[0].add(Arrays.asList(num));
    });
    for (int i = 1; i < n; i++) {
      List<List<Integer>> prev = dp[i - 1];
      dp[i] = new ArrayList<>();
      for (List<Integer> list : prev) {
       for (int num : list) {
          List<Integer> nextPosList = nextPositions(num);
         for (int nextPos : nextPosList){
           if (!list.contains(nextPos)) {
             List<Integer> newList = new ArrayList<>(list);
             newList.add(nextPos);
             dp[i].add(newList);
           }
         }
       }
      }
    }
    int result = 0;
    for (int i = m - 1; i < n; i++) result += dp[i].size();
    return result;
  }

  private List<Integer> nextPositions(int num) {
    List<Integer> result = new ArrayList<>();
    if ((num - 1) % 3 != 0) {
      result.add(num - 1);
      if (num > 4) result.add(num - 4);
      if (num < 7) result.add(num + 2);
    }
    if (num % 3 != 0) {
      if (num < 9) result.add(num + 1);
      if (num < 6) result.add(num + 4);
      if (num > 3) result.add(num - 2);
    }
    if (num - 3 > 0) result.add(num - 3);
    if (num + 3 < 10) result.add(num + 3);

    return result;
  }

  public static void main(String[] args) {
    Prob351 prob351 = new Prob351();
    //System.out.println(prob351.numberOfPatterns(1, 1));
    System.out.println(prob351.numberOfPatterns(1, 2));
  }
}
