package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by ayanc on 12/7/17.
 */
public class Prob739 {
  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = temperatures.length - 1; i > - 1; i--) {
      if (stack.isEmpty()){
        stack.push(i);
        result[i] = 0;
      } else {
        while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
          stack.pop();
        }
        if (stack.isEmpty()) {
          result[i] = 0;
        } else {
          result[i] = stack.peek() - i;
        }
        stack.push(i);
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob739 prob739 = new Prob739();
    Arrays.stream(prob739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).forEach(System.out::println);
  }
}
