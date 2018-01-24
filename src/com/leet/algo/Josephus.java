package com.leet.algo;

/**
 * Created by ayanc on 1/23/18.
 */
public class Josephus {

  public int winner(int n, int k){
    if(n == 1) return 0;
    return (winner(n - 1, k) + k) % n;
  }

  public static void main(String[] args){
    Josephus josephus = new Josephus();
    System.out.println(josephus.winner(7, 3));
    System.out.println(josephus.winner(9, 2));
  }
}
