package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob278 {
  public int firstBadVersion(int n) {
    int start = 1, end = n;
    while (start < end) {
      int mid = start + (end-start) / 2;
      if (!isBadVersion(mid)) start = mid + 1;
      else end = mid;
    }
    return start;
  }

  private boolean isBadVersion(int version){
    return true;
  }
}
