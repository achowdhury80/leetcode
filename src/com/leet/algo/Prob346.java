package com.leet.algo;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob346 {
  /** Initialize your data structure here. */
  private int size;
  private long sum = 0;
  private int count = 0;
  private int[] window;
  int insert = -1;
  public Prob346(int size) {
    this.size = size;
    window = new int[size];
  }

  public double next(int val) {
    insert = ++insert % size;
    if (count == size) sum -= window[insert];
    else count++;
    window[insert] = val;
    sum += val;
    return (sum + 0.0) / count;
  }

  public static void main(String[] args) {
    Prob346 prob346 = new Prob346(3);
    System.out.println(prob346.next(1));
    System.out.println(prob346.next(10));
    System.out.println(prob346.next(3));
    System.out.println(prob346.next(5));
  }
}
