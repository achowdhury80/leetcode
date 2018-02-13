package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob781 {
  public int numRabbits(int[] answers) {
    if (answers == null || answers.length < 1) return 0;
    Arrays.sort(answers);
    int result = 0;
    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == 0) result++;
      else {
        int j = i + 1;
        int count = 1;
        for (; j < answers.length && answers[j] == answers[i]; j++) {
          count++;
        }
        while (count > 0) {
          result += answers[i] + 1;
          count -= (answers[i] + 1);
        }
        i = j - 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob781 prob781 = new Prob781();
    System.out.println(prob781.numRabbits(new int[]{1, 1, 2}));
    System.out.println(prob781.numRabbits(new int[]{10, 10, 10}));
  }
}
