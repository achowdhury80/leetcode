package com.leet.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/29/18.
 */
public class Prob452 {
  public int findMinArrowShots(int[][] points) {
    if (points == null || points.length < 1) return 0;
    Arrays.sort(points, (x, y) -> x[1] - y[1]);
    int arrowPosition = points[0][1];
    int result = 1;
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= arrowPosition) continue;
      arrowPosition = points[i][1];
      result++;
    }
    return result;
  }

  public static void main(String[] args){
    Prob452 prob452 = new Prob452();
    System.out.println(prob452.findMinArrowShots(new int[][]{{10,16}, {2,8}, {1,6}, {7,12}}));
    System.out.println(prob452.findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}));
  }
}
