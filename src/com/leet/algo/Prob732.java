package com.leet.algo;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ayanc on 1/26/18.
 */
public class Prob732 {
  Map<Integer, Integer> timeLine = new TreeMap<>();
  public Prob732() {
    timeLine = new TreeMap<>();
  }
  public int book(int start, int end) {
    timeLine.put(start, timeLine.getOrDefault(start, 0) + 1);
    timeLine.put(end, timeLine.getOrDefault(end, 0) - 1);
    int k = 0, ongoing = 0;
    for(int val : timeLine.values()) k = Math.max(k, ongoing += val);
    return k;
  }


}
