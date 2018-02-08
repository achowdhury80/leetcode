package com.leet.algo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/11/18.
 */
public class Prob313 {
  public int nthSuperUglyNumber(int n, int[] primes) {
    if(n == 1) return 1;
    int[] ugly = new int[n];
    PriorityQueue<Num> heap = new PriorityQueue<>();
    ugly[0] = 1;
    for (int i = 0; i < primes.length; i++) heap.offer(new Num(primes[i], 1, primes[i]));
    for (int i = 1; i < n; i++) {
      ugly[i] = heap.peek().val;
      while (heap.peek().val <= ugly[i]) {
        Num num = heap.poll();
        heap.offer(new Num(num.p * ugly[num.id], num.id + 1, num.p));
      }
    }
    return ugly[n - 1];
  }

  class Num implements Comparable<Num>{
    int val;
    int id;
    int p;
    Num(int val, int id, int p) {
      this.val = val;
      this.id = id;
      this.p = p;
    }
    @Override
    public int compareTo(Num other) {
      return this.val - other.val;
    }
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
