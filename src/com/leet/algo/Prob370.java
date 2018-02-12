package com.leet.algo;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob370 {
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] result = new int[length];
    for (int[] update : updates) {
      result[update[0]] += update[2];
      if (update[1] < length - 1) result[update[1] + 1] -= update[2];
    }
    for (int i = 1; i < length; i++) result[i] = result[i] + result[i - 1];
    return result;
  }

}
/***
 * Assume you have an array of length n initialized with all 0's and are given k update operations.

 Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

 Return the modified array after all k operations were executed.

 Example:

 Given:

 length = 5,
 updates = [
 [1,  3,  2],
 [2,  4,  3],
 [0,  2, -2]
 ]

 Output:

 [-2, 0, 3, 5, 3]
 Explanation:

 Initial state:
 [ 0, 0, 0, 0, 0 ]

 After applying operation [1, 3, 2]:
 [ 0, 2, 2, 2, 0 ]

 After applying operation [2, 4, 3]:
 [ 0, 2, 5, 5, 3 ]

 After applying operation [0, 2, -2]:
 [-2, 0, 3, 5, 3 ]
 Credits:
 Special thanks to @vinod23 for adding this problem and creating all test cases.
 */
