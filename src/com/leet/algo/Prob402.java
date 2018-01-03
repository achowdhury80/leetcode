package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 1/2/18.
 */
public class Prob402 {
  public String removeKdigits(String num, int k) {
    if(num == null || num.length() == 0 || k < 0) return "";
    if(k == 0) return num;
    if(k >= num.length()) return "0";
    Stack<Integer> stack = new Stack<>();
    stack.push(Integer.parseInt(num.charAt(0) + ""));
    String result = "";
    for(int i = 1; i < num.length(); i++){
      int j = Integer.parseInt(num.charAt(i) + "");
      while(!stack.isEmpty() && j < stack.peek()){
        stack.pop();
        k--;
        if(k == 0){
          result = num.substring(i);
          while(!stack.empty()){
            result = stack.pop() + "" + result;
          }
          while(result.length() > 1 && result.startsWith("0")) result = result.substring(1);
          return result;
        }
      }
      stack.push(j);
    }
    while(!stack.isEmpty()){
      result = stack.pop() + "" + result;
    }
    result = result.substring(0, result.length() - k);
    while(result.length() > 1 && result.startsWith("0")) result = result.substring(1);
    return result;
  }

  public static void main(String[] args){
    Prob402 prob402 = new Prob402();
    System.out.println(prob402.removeKdigits("1432219", 3));
    System.out.println(prob402.removeKdigits("10200", 1));
    System.out.println(prob402.removeKdigits("10", 2));
    System.out.println(prob402.removeKdigits("1234567890", 9));
    System.out.println(prob402.removeKdigits("5337", 2));
  }
}
