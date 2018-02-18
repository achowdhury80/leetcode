package com.leet.algo;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob379 {
  boolean[] used;
  TreeSet<Integer> treeSet;
  /** Initialize your data structure here
   @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
  public Prob379(int maxNumbers) {
    used = new boolean[maxNumbers];
    treeSet = new TreeSet<>();
    treeSet.add(0);
  }

  /** Provide a number which is not assigned to anyone.
   @return - Return an available number. Return -1 if none is available. */
  public int get() {
    if (treeSet.isEmpty()) return -1;
    int first = treeSet.pollFirst();
    used[first] = true;
    if (first < used.length - 1 && !used[first + 1]) treeSet.add(first + 1);
    return first;
  }

  /** Check if a number is available or not. */
  public boolean check(int number) {
    if (number >= used.length) return false;
    return !used[number];
  }

  /** Recycle or release a number. */
  public void release(int number) {
    if (number >= used.length) return;
    used[number] = false;
    treeSet.add(number);
  }
}
