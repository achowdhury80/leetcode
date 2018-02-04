package com.leet.algo;

/**
 * Created by ayanc on 2/3/18.
 */
public class Prob134 {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int start = 0;
    int currentVolume = gas[start];
    int currentStation = 0;
    while (start != n) {
      if (cost[currentStation] <= currentVolume) {
        currentVolume = currentVolume - cost[currentStation];
        currentStation = (currentStation + 1) % n;
        if (currentStation == start) return start;
        currentVolume += gas[currentStation];
      } else {
        if (currentStation < start) return -1;
        start = currentStation + 1;
        currentVolume = gas[start % n];
        currentStation = start % n;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Prob134 prob134 = new Prob134();
    System.out.println(prob134.canCompleteCircuit(new int[]{4}, new int[]{5}));
  }
}
