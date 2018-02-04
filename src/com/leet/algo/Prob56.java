package com.leet.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ayanc on 2/3/18.
 */
public class Prob56 {
  static class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
      return "Interval{" +
          "start=" + start +
          ", end=" + end +
          '}';
    }
  }
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> result = new ArrayList<>(intervals);
    if (intervals == null || intervals.size() < 2) return result;
    Collections.sort(result, (Interval x, Interval y) -> {
      if (x.end == y.end) return x.start - y.start;
      return x.end - y.end;
    });
    for (int i = result.size() - 1 ; i > 0; i--) {
      Interval current = result.get(i);
      Interval previous = result.get(i - 1);
      if (current.start <= previous.end) {
        current.start = Math.min(current.start, previous.start);
        result.remove(previous);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob56 prob56 = new Prob56();
    List<Interval> list = new ArrayList<>();
    list.add(new Interval(2,3));
    list.add(new Interval(4,5));
    list.add(new Interval(6,7));
    list.add(new Interval(8,9));
    list.add(new Interval(1,10));
    System.out.println(prob56.merge(list));
  }
}
