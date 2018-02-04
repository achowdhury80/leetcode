package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ayanc on 2/2/18.
 */
public class Prob435 {
  public int eraseOverlapIntervals(Interval[] intervals) {
    if(intervals == null || intervals.length < 2) return 0;
    Arrays.sort(intervals, (x, y) -> x.end - y.end);
    int end = intervals[0].end;
    int count = 1;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start >= end) {
        count++;
        end = intervals[i].end;
      }
    }
    return intervals.length - count;
  }



  class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }
}
