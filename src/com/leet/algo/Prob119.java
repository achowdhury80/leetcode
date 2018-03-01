package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob119 {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    if (rowIndex < 0) return result;
    List<String> row = new ArrayList<>();
    for (int i = 0 ; i <= rowIndex; i++){
      result.add(0, 1);
      for (int j = 1; j < result.size() - 1; j++) {
        result.set(j, result.get(j) + result.get(j + 1));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob119 prob119 = new Prob119();
    System.out.println(prob119.getRow(3));
  }
}
