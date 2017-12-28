package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 9/18/17.
 */
public class Prob155 {
  private Integer minElement = null;
  List<Long> list = new ArrayList();

  /** initialize your data structure here. */
  public Prob155() {

  }

  public void push(int x) {
    if(minElement == null){
      list.add(Long.valueOf(x));
      minElement = x;
    }else{
      if(x >= minElement){
        list.add(0,Long.valueOf(x));
      } else{
        list.add(0, ((2 + 0l) * x) - minElement);
        minElement = x;
      }
    }
  }

  public void pop() {
    if(minElement == null) throw new IllegalArgumentException();
    long x = list.get(0);
    if(x >= minElement) list.remove(0);
    else {
      minElement = Long.valueOf((2 + 0l) * minElement - x).intValue();
      list.remove(0);
    }
    if(list.size() == 0) minElement = null;
  }

  public int top() {
    if(list.size() > 0){
      long x = list.get(0);
      if(x >= minElement) return Long.valueOf(list.get(0)).intValue();
      else return minElement;
    }
    throw new IllegalArgumentException();
  }

  public int getMin() {
    if(minElement == null){
      throw new IllegalArgumentException();
    }
    return minElement;
  }

  public static void main(String[] args){
    Prob155 prob155 = new Prob155();

//    ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
//    [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

//    prob155.push(2147483646);
//    prob155.push(2147483646);
//    prob155.push(2147483647);
//    System.out.println(prob155.list + " - " + prob155.minElement);
//    System.out.println("output:" + prob155.top());
//    prob155.pop();
//    System.out.println(prob155.list + " - " + prob155.minElement);
//    System.out.println("output:" + prob155.getMin());
//    prob155.pop();
//    System.out.println("output:" + prob155.getMin());
//    prob155.pop();
//    System.out.println(prob155.list + " - " + prob155.minElement);
    prob155.push(2147483647);
    System.out.println(prob155.list + " - " + prob155.minElement);
    System.out.println("output:" + prob155.top());
    System.out.println("output:" + prob155.getMin());
    prob155.push(-2147483648);
    System.out.println(prob155.list + " - " + prob155.minElement);
    System.out.println("output:" + prob155.top());
    System.out.println("output:" + prob155.getMin());
    prob155.pop();
    System.out.println(prob155.list + " - " + prob155.minElement);
    System.out.println("output:" + prob155.getMin());


//    prob155.push(-2);
//    System.out.println(prob155.list);
//    System.out.println(prob155.list.get(0));
//    prob155.push(0);
//    System.out.println(prob155.list);
//    System.out.println(prob155.list.get(0));
//    prob155.push(-3);
//    System.out.println(prob155.list);
//    System.out.println(prob155.list.get(0));
//    System.out.println(prob155.getMin());
//    prob155.pop();
//    System.out.println(prob155.list);
//    System.out.println(prob155.list.get(0));
//    System.out.println(prob155.top());
//    System.out.println(prob155.getMin());

  }
}
