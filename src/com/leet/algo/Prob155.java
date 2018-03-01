package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ayanc on 9/18/17.
 */
public class Prob155 {
  private Stack<Integer> stack = null;
  private Stack<Integer> minStack = null;

  /** initialize your data structure here. */
  public Prob155() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
    if (minStack.isEmpty() || minStack.peek() >= x){
      minStack.push(x);
    }
  }

  public void pop() {
    int x = stack.pop();
    if (x == minStack.peek()) minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
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
//    prob155.push(2147483647);
//    //System.out.println(prob155.list + " - " + prob155.minElement);
//    System.out.println("output:" + prob155.top());
//    System.out.println("output:" + prob155.getMin());
//    prob155.push(-2147483648);
//    //System.out.println(prob155.list + " - " + prob155.minElement);
//    System.out.println("output:" + prob155.top());
//    System.out.println("output:" + prob155.getMin());
//    prob155.pop();
//    //System.out.println(prob155.list + " - " + prob155.minElement);
//    System.out.println("output:" + prob155.getMin());


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
