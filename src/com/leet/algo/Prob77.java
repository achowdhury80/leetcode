package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob77 {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if(k > n || n < 1 || k < 1) return result;
    if(n == k){
      List<Integer> list = new ArrayList<>();
      IntStream.range(1,n + 1).forEach(x -> list.add(x));
      result.add(list);
      return result;
    }
    for(int i = n; i > 0; i--){
      if(i >= k){
        List<List<Integer>> sub = combine(i - 1, k - 1);
        if(sub.isEmpty()){
          List<Integer> list = new ArrayList<>();
          list.add(i);
          sub.add(list);
        } else {
          for (List<Integer> list : sub) {
            list.add(i);
          }
        }
        result.addAll(sub);
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob77 prob77 = new Prob77();
    System.out.println(prob77.combine(4, 2));
  }
}
