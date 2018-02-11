package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob624 {

  public int maxDistance(List<List<Integer>> arrays) {
    Integer[][] maxArr = new Integer[2][2];
    Integer[][] minArr = new Integer[2][2];
    for (int i = 0; i < arrays.size(); i++) {
      int min = arrays.get(i).get(0);
      int max = arrays.get(i).get(arrays.get(i).size() - 1);
      if (maxArr[0][0] == null || maxArr[0][0] <= max){
        maxArr[1] = maxArr[0];
        maxArr[0] = new Integer[]{max, i};
      } else if (maxArr[1][0] == null || maxArr[1][0] < max) {
        maxArr[1] = new Integer[]{max, i};
      }

      if (minArr[0][0] == null || minArr[0][0] >= min){
        minArr[1] = minArr[0];
        minArr[0] = new Integer[]{min, i};
      } else if (minArr[1][0] == null || minArr[1][0] > min) {
        minArr[1] = new Integer[]{min, i};
      }
    }
    if (maxArr[0][1] != minArr[0][1]) return Math.abs(maxArr[0][0] - minArr[0][0]);
    int result1 = Math.abs(maxArr[0][0] - minArr[1][0]);
    int result2 = Math.abs(maxArr[1][0] - minArr[0][0]);
    return result1 > result2 ? result1 : result2;
  }

  public static void main(String[] args) {
    Prob624 prob624 = new Prob624();
    List<List<Integer>> arrays = new ArrayList<>();
    arrays.add(Arrays.asList(new Integer[]{1,2,3}));
    arrays.add(Arrays.asList(new Integer[]{4, 5}));
    arrays.add(Arrays.asList(new Integer[]{1,2,3}));
    System.out.println(prob624.maxDistance(arrays));
  }
}
