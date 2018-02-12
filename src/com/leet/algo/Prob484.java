package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob484 {
  public int[] findPermutation(String s) {
    if(s == null || s.length() < 1) return new int[0];
    int[] arr = new int[s.length() + 1];
    IntStream.range(0, arr.length).forEach(idx -> arr[idx] = idx + 1);
    int i = 0;
    while (i < s.length()) {
      if (s.charAt(i) == 'D') {
        int j = i + 1;
        while (j < s.length() && s.charAt(j) == 'D') j++;
        int m = i;
        i = j;
        while (m < j) {
          swap(arr, m, j);
          m++;
          j--;
        }
      } else i++;
    }
    return arr;
  }
  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    Prob484 prob484 = new Prob484();
    final int[] arr;
    //arr = prob484.findPermutation("I");
    arr = prob484.findPermutation("DI");
    IntStream.range(0, arr.length).forEach(x -> System.out.print(arr[x] + ","));
  }
}
/**
 * Find Permutation
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 By now, you are given a secret signature consisting of character 'D' and 'I'. 'D' represents a decreasing relationship between two numbers, 'I' represents an increasing relationship between two numbers. And our secret signature was constructed by a special integer array, which contains uniquely all the different number from 1 to n (n is the length of the secret signature plus 1). For example, the secret signature "DI" can be constructed by array [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or [2,1,3,4], which are both illegal constructing special string that can't represent the "DI" secret signature.

 On the other hand, now your job is to find the lexicographically smallest permutation of [1, 2, ... n] could refer to the given secret signature in the input.

 Example 1:
 Input: "I"
 Output: [1,2]
 Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I", where the number 1 and 2 construct an increasing relationship.
 Example 2:
 Input: "DI"
 Output: [2,1,3]
 Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI",
 but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]
 Note:

 The input string will only contain the character 'D' and 'I'.
 The length of input string is a positive integer and will not exceed 10,000
 */
