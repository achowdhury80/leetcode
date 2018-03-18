package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob232 {
  /** Initialize your data structure here. */
  private Stack<Integer> emptyStack = null;
  private Stack<Integer> nonEmptyStack = null;
  private boolean reversed = false;

  public Prob232() {
    emptyStack = new Stack<>();
    nonEmptyStack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    if(reversed){
      while(!nonEmptyStack.empty()){
        emptyStack.push(nonEmptyStack.pop());
      }
      Stack<Integer> temp = nonEmptyStack;
      nonEmptyStack = emptyStack;
      emptyStack = temp;
      reversed = false;
    }
    nonEmptyStack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if(!reversed){
      while(!nonEmptyStack.empty()){
        emptyStack.push(nonEmptyStack.pop());
      }
      Stack<Integer> temp = nonEmptyStack;
      nonEmptyStack = emptyStack;
      emptyStack = temp;
      reversed = true;
    }
    return nonEmptyStack.pop();
  }

  /** Get the front element. */
  public int peek() {
    if(!reversed){
      while(!nonEmptyStack.empty()){
        emptyStack.push(nonEmptyStack.pop());
      }
      Stack<Integer> temp = nonEmptyStack;
      nonEmptyStack = emptyStack;
      emptyStack = temp;
      reversed = true;
    }
    return nonEmptyStack.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return nonEmptyStack.empty();
  }
}
