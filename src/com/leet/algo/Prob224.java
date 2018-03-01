package com.leet.algo;

import java.util.Stack;
import java.util.stream.Collector;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob224 {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int sign = 1;
    int number = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        number = number * 10 + (int)(c - '0');
      } else if (c == '+') {
        result += sign * number;
        number = 0;
        sign = 1;
      } else if (c == '-') {
        result += sign * number;
        number = 0;
        sign = -1;
      } else if (c == '(') {
        stack.push(result);
        stack.push(sign);
        result = 0;
        sign = 1;
      } else if (c == ')') {
        result += sign * number;
        number = 0;
        result = stack.pop() * result;
        result += stack.pop();
      }
    }
    if (number != 0) result += sign * number;
    return result;
  }


}
