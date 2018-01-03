package com.leet.algo;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ayanc on 1/2/18.
 */
public class Prob735 {
  public int[] asteroidCollision(int[] asteroids) {
    if(asteroids == null || asteroids.length < 1) return new int[0];
    if(asteroids.length < 2) return asteroids;
    Stack<Integer> stack = new Stack<>();
    Arrays.stream(asteroids).forEach(x -> {
      if(stack.isEmpty() || stack.peek() < 0 || x > 0) stack.push(x);
      else {
        Integer temp = x;
        while(!stack.isEmpty() && stack.peek() > 0 && temp < 0){
          if(Math.abs(stack.peek()) == Math.abs(temp)){
            stack.pop();
            temp = null;
            break;
          } else {
            if(Math.abs(temp) < Math.abs(stack.peek())){
              temp = stack.pop();
            } else stack.pop();
          }
        }
        if(temp != null) stack.push(temp);
      }
    });
    if(stack.isEmpty()) return new int[0];
    int[] result = new int[stack.size()];
    for(int i = result.length - 1; i > -1; i--){
      result[i] = stack.pop();
    }
    return result;
  }
}
