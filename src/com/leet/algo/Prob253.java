package com.leet.algo;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * Created by ayanc on 2/16/18.
 */
public class Prob253 {
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length < 1) return 0;
    Arrays.sort(intervals, (x, y) -> x.start - y.start);
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int result = 0;
    int count = 0;
    for (int i = 0; i < intervals.length; i++) {
      while (!heap.isEmpty() && intervals[i].start >= heap.peek()) {
        heap.poll();
        count--;
      }
      heap.offer(intervals[i].end);
      count++;
      result = Math.max(result, count);
    }
    return result;
  }
  static class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
  }

  public static void main(String[] args) {
    Prob253 prob253 = new Prob253();
    System.out.println(prob253.minMeetingRooms(new Interval[]{new Interval(0, 30),new Interval(5, 10),new Interval(15, 20)}));
  }
}
