package com.leet.algo;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob487 {
  public int findMaxConsecutiveOnes(int[] nums) {
    int current = 0;
    int previous = 0;
    int maximum = 0;
    for (int num : nums) {
      if (num == 1) current++;
      else {
        previous = current;
        current = 0;
      }
      maximum = Math.max(maximum, previous + current + 1);
    }
    return maximum > nums.length ? maximum - 1 : maximum;
  }

  public static void main(String[] args) {
    Prob487 prob487 = new Prob487();
    System.out.println(prob487.findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));
    System.out.println(prob487.findMaxConsecutiveOnes(new int[]{1}));
  }
}
