package com.leet.algo;

/**
 * Created by ayanc on 2/26/18.
 */
public class MaxBinaryGap {
  public int findMaxGap(int num) {
    int count = -1;
    int mask = 1;
    int result = 0;
    for (int i = 0; i < 32; i++) {
      if ((num & mask) > 0) {
        if (count < 0) count++;
        else if (count > 0) {
          result = Math.max(result, count);
          count = 0;
        }
      } else {
        if (count >= 0) count++;
      }
      mask = (mask << 1);
    }
    return result;
  }

  public static void main(String[] args) {
    MaxBinaryGap maxBinaryGap = new MaxBinaryGap();
    System.out.println(maxBinaryGap.findMaxGap(9));
    System.out.println(maxBinaryGap.findMaxGap(20));
    System.out.println(maxBinaryGap.findMaxGap(51712));
    System.out.println(maxBinaryGap.findMaxGap(65));
  }
}
