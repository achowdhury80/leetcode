package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob118 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      row.add(0, 1);
      for (int j = 1; j < row.size() - 1; j++) row.set(j, row.get(j) + row.get(j + 1));
      result.add(new ArrayList<>(row));
    }
    return result;
  }

  public static void main(String[] args) {
    Prob118 prob118 = new Prob118();
    System.out.println(prob118.generate(5));
  }
}
