package com.leet.algo;

import java.util.PriorityQueue;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob556 {
  public int nextGreaterElement(int n) {
    if(n < 12) return -1;
    String s = String.valueOf(n);
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Integer x, Integer y) -> y.compareTo(x));
    priorityQueue.add(s.charAt(s.length() - 1) - '0');
    long temp = -1;
    for(int i = s.length() - 2; i > -1; i--){
      priorityQueue.add(s.charAt(i) - '0');
      int digit = s.charAt(i) - '0';
      if(priorityQueue.peek() > digit){
        String prefix = "";
        if(i > 0){
          prefix = s.substring(0, i);
        }
        String suffix = "";
        while (priorityQueue.peek() > digit){
          suffix = priorityQueue.poll() + suffix;
        }
        prefix += suffix.charAt(0);
        if(suffix.length() > 0) suffix = suffix.substring(1);
        else suffix = "";
        while (!priorityQueue.isEmpty()){
          suffix = priorityQueue.poll() + suffix;
        }
        temp = Long.parseLong(prefix + suffix);
        if(temp <= Integer.MAX_VALUE) return (int)temp;
        else return -1;
      }
    }
    return -1;
  }

  public static void main(String[] args){
    Prob556 prob556 = new Prob556();
//    System.out.println(prob556.nextGreaterElement(12));
    System.out.println(prob556.nextGreaterElement(12222333));
  }
}
