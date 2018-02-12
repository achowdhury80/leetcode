package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob544 {
  public String findContestMatch(int n) {
    if (n < 2) return "";
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) list.add("" + i);
    while (list.size() != 1) {
      List<String> temp = new ArrayList<>();
      while (!list.isEmpty()) temp.add("(" + list.remove(0) + "," + list.remove(list.size() - 1) + ")");
      list = temp;
    }
    return list.get(0);
  }

  public static void main(String[] args) {
    Prob544 prob544 = new Prob544();
    System.out.println(prob544.findContestMatch(8));
  }
}

