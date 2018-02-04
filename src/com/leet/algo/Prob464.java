package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 2/3/18.
 */
public class Prob464 {
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if ((maxChoosableInteger * (maxChoosableInteger + 1)) / 2 < desiredTotal) return false;
    boolean[] used = new boolean[maxChoosableInteger + 1];
    Map<Integer, Boolean> map = new HashMap<>();
    return canIWin(used, desiredTotal, map);
  }

  public boolean canIWin(boolean[] used, int desiredTotal, Map<Integer, Boolean> map) {
    int encodedVal = encode(used);
    if (map.containsKey(encodedVal)) return map.get(encodedVal);
    for (int i = 1; i < used.length; i++) {
      if (!used[i] && i >= desiredTotal) {
        used[i] = true;
        map.put(encode(used), true);
        used[i] = false;
        return true;
      }
    }
    for (int i = 1; i < used.length; i++) {
      if (used[i]) continue;
      used[i] = true;
      if (!canIWin(used, desiredTotal - i, map)) {
        map.put(encodedVal, true);
        used[i] = false;
        return true;
      }
      used[i] = false;
    }
    map.put(encodedVal, false);
    return false;
  }

  int encode(boolean[] used) {
    int result = 0;
    int mask = 1;
    for (int i = 1; i < used.length; i++) {
      mask = (mask << 1);
      if (used[i]) result = (result | mask);
    }
    return result;
  }

  public static void main(String[] args) {
    Prob464 prob464 = new Prob464();
    System.out.println(prob464.canIWin(10, 11));
    System.out.println(prob464.canIWin(20, 210));
    System.out.println(prob464.canIWin(10, 40));
  }
}
