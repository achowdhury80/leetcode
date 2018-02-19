package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/18/18.
 */
public class Prob755 {
  public int[] pourWater(int[] heights, int V, int K) {
    if (heights == null || heights.length < 1 || V == 0) return heights;
    int index;
    while (V > 0) {
      index = K;
      for (int i = K - 1; i > -1; i--) {
        if (heights[i] > heights[index]) break;
        else if (heights[i] < heights[index]) index = i;
      }
      if (index != K) heights[index]++;
      else {
        for (int i = K + 1; i < heights.length; i++) {
          if (heights[i] > heights[index]) break;
          else if (heights[i] < heights[index]) index = i;
        }
        heights[index]++;
      }
      V--;
    }
    return heights;
  }

  public static void main(String[] args) {
    Prob755 prob755 = new Prob755();
    int[] result;
    result = prob755.pourWater(new int[]{2,1,1,2,1,2,2}, 4, 3);
    for (int i = 0; i < result.length; i++) System.out.print(result[i] + ",");
    System.out.println();

    result = prob755.pourWater(new int[]{1,2,3,4}, 2, 2);
    for (int i = 0; i < result.length; i++) System.out.print(result[i] + ",");
    System.out.println();

    result = prob755.pourWater(new int[]{3, 1, 3}, 5, 1);
    for (int i = 0; i < result.length; i++) System.out.print(result[i] + ",");
    System.out.println();

    result = prob755.pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1}, 5, 2);
    for (int i = 0; i < result.length; i++) System.out.print(result[i] + ",");
    System.out.println();

  }
}
