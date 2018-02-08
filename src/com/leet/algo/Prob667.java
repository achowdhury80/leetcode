package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/27/17.
 */
public class Prob667 {
  public int[] constructArray(int n, int k) {
    if(n < 2 || k < 1) return null;
    int[] result = new int[n];
    int[] nums = new int[n + 1];
    IntStream.range(0, nums.length).forEach(idx -> nums[idx] = idx);
    for (int i = 0, l = 1, r = n; l <= r; i++) {
      result[i] = k > 1 ? ((k-- % 2 == 0) ? r-- : l++) : l++;
    }
    return result;
  }



  public static void main(String[] args) {
    Prob667 prob667 = new Prob667();
    Arrays.stream(prob667.constructArray(3, 1)).forEach(x -> System.out.print(x + ", "));
    System.out.println();
    Arrays.stream(prob667.constructArray(3, 2)).forEach(x -> System.out.print(x + ", "));
  }
}
