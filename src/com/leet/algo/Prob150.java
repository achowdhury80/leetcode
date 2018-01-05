package com.leet.algo;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob150 {
  public int evalRPN(String[] tokens) {
    if(tokens == null || tokens.length < 1) return 0;
    Stack<Integer> stack = new Stack<>();
    IntStream.range(0, tokens.length).forEach(x -> {
      String token = tokens[x];
      if(isOperator(token)){
        int operand2 = stack.pop();
        int operand1 = stack.pop();
        int val = 0;
        if(token.equals("+")) val = operand1 + operand2;
        else if(token.equals("-")) val = operand1 - operand2;
        else if(token.equals("*")) val = operand1 * operand2;
        else if(token.equals("/")) val = operand1 / operand2;
        stack.push(val);
      } else {
        stack.push(Integer.valueOf(token));
      }
    });
    return stack.pop();
  }

  private boolean isOperator(String s){
    return s.length() == 1 && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
  }

  public static void main(String[] args){
    Prob150 prob150 = new Prob150();
    //System.out.println(prob150.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    System.out.println(prob150.evalRPN(new String[]{"0", "3", "/"}));
  }
}
