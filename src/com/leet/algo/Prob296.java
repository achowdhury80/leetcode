package com.leet.algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by ayanc on 2/22/18.
 */
public class Prob296 {
  public int minTotalDistance(int[][] grid) {
    if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
    List<Integer> listX = new ArrayList<>();
    List<Integer> listY = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          listX.add(i);
          listY.add(j);
        }
      }
    }
    return getMin(listX) + getMin(listY);

  }

  private int getMin(List<Integer> list) {
    Collections.sort(list);
    int i = 0, j = list.size() - 1;
    int result = 0;
    while (i < j) result += list.get(j--) -list.get(i++);
    return result;
  }

  public static void main(String[] args) {
    Prob296 prob296 = new Prob296();
    System.out.println(prob296.minTotalDistance(new int[][]{{1,0,0,0,1}, {0,0,0,0,0}, {0,0,1,0,0}}));
  }
}
