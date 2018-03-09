package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob32 {
  //O(n)
  public int longestValidParentheses(String s) {
    if (s == null || s.length() < 2) return 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (stack.empty()) stack.push(i);
      else {
        char stackPeek = s.charAt(stack.peek());
        if (stackPeek == '(' && c == ')') stack.pop();
        else stack.push(i);
      }
    }
    if (stack.size() == 0) return s.length();
    int top = stack.pop();
    int result = s.length() - top - 1;
    while (!stack.isEmpty()) {
      int next = stack.pop();
      result = Math.max(result, top - next - 1);
      top = next;
    }
    result = Math.max(result, top);
    return result;
  }

  public static void main(String[] args) {
    Prob32 prob32 = new Prob32();
    System.out.println(prob32.longestValidParentheses("(()"));
    System.out.println(prob32.longestValidParentheses(")()())"));
  }
}
