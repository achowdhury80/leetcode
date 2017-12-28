package com;

import java.util.Stack;

/**
 * Created by ayanc on 10/20/17.
 */
public class Prob682 {
  public int calPoints(String[] ops) {
    if(ops == null || ops.length == 0) return 0;
    Stack<Integer> stack = new Stack<>();
    int sum = 0;
    for(String s : ops){
      if("C".equals(s)){
        int pt = stack.pop();
        sum -= pt;
      } else if("D".equals(s)){
        int pt = stack.peek();
        stack.push(2 * pt);
        sum += 2 * pt;
      } else if("+".equals(s)){
        int last = stack.pop();
        int secondLast = stack.peek();
        stack.push(last);
        int newVal = last + secondLast;
        stack.push(newVal);
        sum += newVal;
      } else{
        int val = Integer.valueOf(s);
        stack.push(val);
        sum += val;
      }
    }
    return sum;
  }

  public static void main(String[] args){
    Prob682 prob682 = new Prob682();
    //System.out.println(prob682.calPoints(new String[]{"5","2","C","D","+"}));
    System.out.println(prob682.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
  }
}
