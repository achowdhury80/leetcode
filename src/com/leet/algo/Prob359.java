package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob359 {
  private Map<String, Integer> map = null;
  /** Initialize your data structure here. */
  public Prob359() {
    map = new HashMap<>();
  }

  /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
   If this method returns false, the message will not be printed.
   The timestamp is in seconds granularity. */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (map.containsKey(message)) {
      if (map.get(message) + 10 > timestamp) return false;
      map.put(message, timestamp);
    } else {
      map.put(message, timestamp);
    }
    return true;
  }
}
