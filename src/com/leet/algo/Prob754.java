package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 2/3/18.
 */
public class Prob754 {
  public int reachNumber(int target) {
    if (target == 0) return 0;
    target = Math.abs(target);
    int step = 0;
    int sum = 0;
    while (sum < target) {
      step++;
      sum += step;
    }
    while ((sum - target) % 2 != 0) {
      step++;
      sum += step;
    }
    return step;
  }

  public static void main(String[] args) {
    Prob754 prob754 = new Prob754();
//    System.out.println(prob754.reachNumber(3));
//    System.out.println(prob754.reachNumber(2));
    System.out.println(prob754.reachNumber(-1000000000));
  }
}
