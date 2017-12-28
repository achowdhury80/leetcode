package com.leet.algo;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ayanc on 7/18/17.
 */
public class ValidParenthesis {
  public class Solution {
    public boolean isValid(String s) {
      if(s == null || s.length() == 0) return true;
      Stack<Character> stack = new Stack<>();
      for(int i = 0; i < s.length(); i++){
        char ch = s.charAt(i);
        if(isParenthesisStart(ch)) stack.push(ch);
        else if(isParenthesisEnd(ch)){
          if(stack.isEmpty()) return false;
          char poppedChar = stack.pop();
          if(ch == ')' && poppedChar != '(' || ch == '{' && poppedChar != '}' || ch == '[' && poppedChar != ']') return false;
        }
      }
      return stack.empty();

    }

    private boolean isParenthesisStart(char c){
      return Arrays.asList(new Character[]{'(', '{', '['}).contains(c);
    }

    private boolean isParenthesisEnd(char c){
      return Arrays.asList(new Character[]{')', '}', ']'}).contains(c);
    }
  }
}
