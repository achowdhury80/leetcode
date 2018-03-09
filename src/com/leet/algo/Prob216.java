package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob216 {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    if(k > 9 || k < 1) return result;
    combinationSum3(result, k, n, new ArrayList<>(), 1);
    return result;
  }

  private void combinationSum3(List<List<Integer>> result, int k, int n, List<Integer> temp, int start){
    if (n == 0 && k == 0){
      result.add(new ArrayList<>(temp));
      return;
    }
    if (n == 0 || k == 0) return;
    for (int i = start; i <= 9; i++) {
      if (n < i) {
        break;
      }
      temp.add(i);
      combinationSum3(result, k - 1, n - i, temp, i + 1);
      temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args){
    Prob216 prob216 = new Prob216();
    System.out.println(prob216.combinationSum3(3, 7));
    System.out.println(prob216.combinationSum3(3, 9));
  }
}
