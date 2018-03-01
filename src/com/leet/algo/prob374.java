package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class prob374 {
  public int guessNumber(int n) {
    int low = 1;
    int high = n;
    while (low < high) {
      int mid = (low + high) / 2;
      int res = guess(mid);
      if (res == 0)
        return mid;
      if (res < 0)
        high = mid - 1;
      else low = mid + 1;
    }
    return low;
  }

  private int guess(int i){
    return 0;
  }
}
