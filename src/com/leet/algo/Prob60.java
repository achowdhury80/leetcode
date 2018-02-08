package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/5/18.
 */
public class Prob60 {
  public String getPermutation(int n, int k) {
    List<Integer> nums = new ArrayList<>();
    IntStream.range(1, n + 1).forEach(x -> nums.add(x));
    int[] fact = new int[n];
    fact[0] = 1;
    for (int i = 1; i < n; i++) fact[i] = fact[i - 1] * i;
    StringBuilder result = new StringBuilder();
    k = k - 1;
    for (int i = n; i > 0; i--) {
      int ind = k / fact[i - 1];
      k = k - ind * fact[i - 1];
      result.append(nums.get(ind));
      nums.remove(ind);
    }
    return result.toString();
  }

  public static void main(String[] args) {
    Prob60 prob60 = new Prob60();
    System.out.println(prob60.getPermutation(4, 13));
    System.out.println(prob60.getPermutation(4, 24));
    System.out.println(prob60.getPermutation(4, 1));
    System.out.println(prob60.getPermutation(4, 7));
  }
}
