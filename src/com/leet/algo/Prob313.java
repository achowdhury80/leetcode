package com.leet.algo;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/11/18.
 */
public class Prob313 {
  public int nthSuperUglyNumber(int n, int[] primes) {
    if(n == 1) return 1;
    long[] next = new long[primes.length];
    IntStream.range(0, primes.length).forEach(x -> next[x] = primes[x]);
    int result = -1;
    for (int i = 1; i < n; i++) {
      Arrays.sort(next);
      long min = next[0] == 1 ? next[1] : next[0];
      for (int j = 0; j < primes.length; j++) {
        if (min == next[j]) next[j] = findNext(min, primes);
      }
      result = (int)min;
    }
    return result;
  }

  private long findNext(long last, int[] primes) {
    long min = Integer.MAX_VALUE;
    for (int i = 0; i < primes.length; i++) {
      if (primes[i] != 1) min = Math.min(min, last * primes[i]);
    }
    return min;
  }

  public static void main(String[] args) {
    Prob313 prob313 = new Prob313();
//    for (int i = 1; i < 13; i++) {
//      System.out.println(prob313.nthSuperUglyNumber(i, new int[]{2, 7, 13, 19}));
//    }
    //for (int i = 1; i < 16; i++)
    System.out.println(prob313.nthSuperUglyNumber(15, new int[]{3,5,7,11,19,23,29,41,43,47}));

  }
}
