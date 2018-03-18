package com.leet.algo;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 3/16/18.
 */
public class Prob460 {
  private int capacity;
  private Map<Integer, Integer> freqMap;
  private Map<Integer, Integer> valMap;
  private Map<Integer, LinkedHashSet<Integer>> lists;
  private int minFreq;
  public Prob460(int capacity) {
    this.capacity = capacity;
    freqMap = new HashMap<>();
    lists = new HashMap<>();
    valMap = new HashMap<>();
    minFreq = 0;
  }

  public int get(int key) {
    if (!valMap.containsKey(key)) return -1;
    int curFreq = freqMap.get(key);
    LinkedHashSet<Integer> integers = lists.get(curFreq);
    integers.remove(key);
    if (integers.isEmpty()) {
      if (minFreq == curFreq) minFreq++;
    }
    if (!lists.containsKey(curFreq + 1)) lists.put(curFreq + 1, new LinkedHashSet<>());
    lists.get(curFreq + 1).add(key);
    freqMap.put(key, curFreq + 1);
    return valMap.get(key);
  }

  public void put(int key, int value) {
    if (capacity <= 0) return;
    if (valMap.containsKey(key)) {
      valMap.put(key, value);
      get(key);
      return;
    }
    if (valMap.size() == capacity) {
      int evict = lists.get(minFreq).iterator().next();
      lists.get(minFreq).remove(evict);
      freqMap.remove(evict);
      valMap.remove(evict);
    }
    valMap.put(key, value);
    freqMap.put(key, 1);
    minFreq = 1;
    if (!lists.containsKey(minFreq)) lists.put(minFreq, new LinkedHashSet<>());
    lists.get(minFreq).add(key);
  }
}
