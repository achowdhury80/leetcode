package com.leet.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob436 {
  public int[] findRightInterval(Interval[] intervals) {
    if(intervals == null || intervals.length < 1) return new int[0];
    if(intervals.length < 2) return new int[]{-1};
    Map<Integer, Integer> map = new HashMap<>();
    int[] arr = new int[intervals.length];
    for(int i = 0; i < intervals.length; i++){
      arr[i] = intervals[i].start;
      map.put(intervals[i].start, i);
    }
    Arrays.sort(arr);
    int[] result = new int[intervals.length];
    for(int i = 0; i < intervals.length; i++){
      int next = findNextInterval(arr, intervals[i].end);
      result[i] = next;
      if(next == -1) result[i] = next;
      else result[i] = map.get(arr[next]);
    }
    return result;
  }

  private int findNextInterval(int[] arr, int target){
    int start = 0;
    int end = arr.length - 1;
    while(start < end){
      int mid = (start + end) / 2;
      if(arr[mid] == target) return mid;
      if(arr[mid] < target) start = mid + 1;
      else {
        if(mid == 0 || (mid > 0 && arr[mid - 1] < target)) return mid;
        end = mid - 1;
      }
    }
    if(start == end && arr[end] >= target) return end;
    return -1;
  }

  static class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }

  public static void main(String[] args){
    Prob436 prob436 = new Prob436();
    int[] result;
    result = prob436.findRightInterval(new Interval[]{new Interval(1, 2)});
    Arrays.stream(result).forEach(x -> System.out.print(x + ", "));
    System.out.println();
    result = prob436.findRightInterval(new Interval[]{new Interval(3, 4), new Interval(2, 3), new Interval(1, 2)});
    Arrays.stream(result).forEach(x -> System.out.print(x + ", "));
    System.out.println();
    result = prob436.findRightInterval(new Interval[]{new Interval(1, 4), new Interval(2, 3), new Interval(3, 4)});
    Arrays.stream(result).forEach(x -> System.out.print(x + ", "));
    System.out.println();
    result = prob436.findRightInterval(new Interval[]{new Interval(-2, 0), new Interval(-1, 1), new Interval(0, 2), new Interval(1, 3), new Interval(2, 5)});
    Arrays.stream(result).forEach(x -> System.out.print(x + ", "));
  }
}
