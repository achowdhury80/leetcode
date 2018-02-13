package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob360 {
  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int n;
    if(nums == null || (n = nums.length) < 1) return new int[0];
    int[] result = new int[n];
    int index = a >= 0 ? n - 1 : 0;
    int i = 0, j = n - 1;
    while (i <= j) {
      int l = quad(nums[i], a, b, c);
      int m = quad(nums[j], a, b, c);
      if (a >= 0) {
        if (l > m) {
          result[index--] = l;
          i++;
        } else {
          result[index--] = m;
          j--;
        }
      } else {
        if (l > m) {
          result[index++] = m;
          j--;
        } else {
          result[index++] = l;
          i++;
        }
      }
    }
    return result;
  }

  private int quad(int x, int a, int b, int c) {
    return a * x * x + b * x + c;
  }

  public static void main(String[] args) {
    Prob360 prob360 = new Prob360();
    final int[] arr;
    //arr = prob360.sortTransformedArray(new int[]{-4, -2, 2, 4}, 1, 3, 5);
    //IntStream.range(0, arr.length).forEach(x -> System.out.print(arr[x] + ","));
    arr = prob360.sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5);
    IntStream.range(0, arr.length).forEach(x -> System.out.print(arr[x] + ","));
  }
}
