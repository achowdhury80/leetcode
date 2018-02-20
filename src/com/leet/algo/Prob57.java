package com.leet.algo;

import java.util.List;

/**
 * Created by ayanc on 2/20/18.
 */
public class Prob57 {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    intervals.add(0, newInterval);
    if (intervals.size() == 1) {
      return intervals;
    }
    int size = intervals.size();
    for (int i = 1; i < size; i++) {
      if (intervals.get(i - 1).end < intervals.get(i).start) return intervals;
      if (intervals.get(i - 1).start > intervals.get(i).end) {
        swap(intervals, i - 1, i);
        continue;
      }
      intervals.get(i - 1).start = Math.min(intervals.get(i - 1).start, intervals.get(i).start);
      intervals.get(i - 1).end = Math.max(intervals.get(i - 1).end, intervals.get(i).end);
      intervals.remove(i);
      i--;
      size--;
    }
    return intervals;
  }

  private void swap(List<Interval> intervals, int i, int j) {
    Interval temp = intervals.get(i);
    intervals.set(i, intervals.get(j));
    intervals.set(j, temp);
  }
  class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }

  public static void main(String[] args) {
    Prob57 prob57 = new Prob57();
    prob57.insert()
  }
}
