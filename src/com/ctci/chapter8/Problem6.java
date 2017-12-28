package com.ctci.chapter8;

/**
 * Created by ayanc on 7/23/17.
 */
public class Problem6 {
  public static void main(String[] args){
    Problem6 problem6 = new Problem6();
    problem6.moveDisks(3, 1, 2, 3);
  }
  private void moveDisks(int n, int originPoll, int bufferPoll, int destinationPoll){
    if(n > 0){
      moveDisks(n - 1, originPoll, destinationPoll, bufferPoll);
      System.out.println("Move disk from poll " + originPoll + " to poll " + destinationPoll);
      moveDisks(n - 1, bufferPoll, originPoll, destinationPoll);
    }
  }
}
