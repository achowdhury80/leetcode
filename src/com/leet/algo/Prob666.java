package com.leet.algo;

/**
 * Created by ayanc on 2/15/18.
 */
public class Prob666 {
  public int pathSum(int[] nums) {
    int[] sum = new int[15];
    for (int num : nums) {
      int d = num / 100;
      int pos = (num % 100) / 10;
      int val = (num % 100) % 10;
      int index = findIndex(d, pos);
      sum[index] = val;
      int parentIndex = -1;
      if (d > 1) {
        parentIndex = findIndex(d - 1, (pos + 1) / 2);
        sum[index] += Math.abs(sum[parentIndex]);
        sum[parentIndex] = sum[parentIndex] > 0 ? -1 * sum[parentIndex] : sum[parentIndex];
      }
    }
    int result = 0;
    for (int i = 0; i < 15; i++) {
      result += sum[i] > 0 ? sum[i] : 0;
    }
    return result;
  }

  private int findIndex(int currentLevel, int pos) {
    return (int)Math.pow(2, currentLevel - 1) - 1 + pos - 1;
  }

  public static void main(String[] args) {
    Prob666 prob666 = new Prob666();
    System.out.println(prob666.pathSum(new int[]{113, 215, 221}));
    System.out.println(prob666.pathSum(new int[]{113, 221}));
  }
}
