package com.leet.algo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob251 implements Iterator<Integer> {
  private List<List<Integer>> vec2d;
  private int[] current;
  public Prob251(List<List<Integer>> vec2d) {
    if (vec2d == null) return;
    this.vec2d = vec2d;
    for (int i = 0; i < vec2d.size(); i++) {
      if (vec2d.get(i) == null || vec2d.get(i).size() == 0) continue;
      else {
        current = new int[]{i, 0};
        break;
      }
    }
  }

  @Override
  public Integer next() {
    if (current == null) return null;
    List<Integer> list = vec2d.get(current[0]);
    Integer val = list.get(current[1]);
    int[] next = new int[]{current[0], current[1]};
    current = null;
    if (list.size() == next[1] + 1) {
      next[0]++;
      next[1] = 0;
    } else {
      next[1]++;
      current = next;
    }
    if (current == null) {
      for (int i = next[0]; i < vec2d.size(); i++) {
        if (vec2d.get(i) == null || vec2d.get(i).size() == 0) continue;
        else {
          current = new int[]{i, 0};
          break;
        }
      }
    }
    return val;
  }

  @Override
  public boolean hasNext() {
    return current != null;
  }

  public static void main(String[] args) {
    Prob251 prob251 = new Prob251(Arrays.asList(Arrays.asList(1,2), Arrays.asList(3), Arrays.asList(4, 5, 6)));
    while (prob251.hasNext()) System.out.print(prob251.next());
  }
}
