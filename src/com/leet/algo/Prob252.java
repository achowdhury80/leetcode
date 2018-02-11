package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob252 {
  class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }
  public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, (x, y) -> x.end - y.end);
    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i].end > intervals[i + 1].start) return false;
    }
    return true;
  }
}
