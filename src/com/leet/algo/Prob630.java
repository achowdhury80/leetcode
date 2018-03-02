package com.leet.algo;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ayanc on 3/1/18.
 */
public class Prob630 {
  public int scheduleCourse(int[][] courses) {
    if (courses == null) return 0;
    Arrays.sort(courses, (x, y) -> x[1] - y[1]);
    int time = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
    for (int[] c : courses) {
      time += c[0];
      heap.offer(c[0]);
      if (time > c[1]) time -= heap.poll();
    }
    return heap.size();
  }
}
