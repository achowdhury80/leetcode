package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob456 {
  public boolean find132pattern(int[] nums) {
    if(nums == null || nums.length < 3) return false;
    Stack<Integer> stack = new Stack<>();
    stack.push(nums[0]);
    boolean minPushed = true;
    for(int i = 2; i < nums.length; i++){
      int num = nums[i];
      if(stack.size() == 1){
        if(num > stack.peek()) stack.push(num);
        else if(num < stack.peek()) {
          stack.pop();
          stack.push(num);
        }
      } else {
        if(minPushed){
          if(num > stack.peek()) {
            stack.push(num);
            minPushed = false;
          } else if(num < stack.peek()){
            stack.pop();
            stack.push(num);
          }
        } else {
          if(num > stack.peek()){
            stack.pop();
            stack.push(num);
          } else if(num < stack.peek()){
            stack.push(num);
            minPushed = true;
          }
        }

      }
    }

    while(stack.size() > 2) {
      int last = stack.pop();
      int seconLast = stack.pop();
      int thirdLast = stack.pop();
    }
    return true;
  }
}
