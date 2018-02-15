package com.leet.algo;

/**
 * Created by ayanc on 2/13/18.
 */
public class Prob277 {
  public int findCelebrity(int n) {
    int probCeleb = 0;
    for (int i = 1; i < n; i++) {
      if (!knows(i, probCeleb)) {
        probCeleb = i;
      }
    }
    for (int i = 0; i < n; i++) {
      if (i != probCeleb && (knows(probCeleb, i) || !knows(i, probCeleb))) {
        return -1;
      }
    }
    return probCeleb;
  }

  boolean knows(int a, int b){
    return true;
  }
}
