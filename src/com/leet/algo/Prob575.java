package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 8/15/17.
 */
public class Prob575 {
  public int distributeCandies(int[] candies) {
    if(candies == null || candies.length < 2) return 0;
    Set<Integer> set = new HashSet<>();

    for(int i = 0; i < candies.length; i++){
      set.add(candies[i]);
    }

    if(candies.length / 2 >= set.size()) return set.size();
    return candies.length / 2;
  }
}
