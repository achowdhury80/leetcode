package com.prep2020.medium;

import java.util.Stack;

public class Problem394 {
	public String decodeString(String s) {
	    if(s == null || s.length() == 0) return "";
	    Stack<String> stack = new Stack<>();
	    String num = "";
	    String str = "";
	    for(int i = 0; i < s.length(); i++){
	      char c = s.charAt(i);
	      if(c >= '0' && c <= '9'){
	        num += c;
	        if(!str.equals("")){
	          while (!stack.isEmpty() && !stack.peek().equals("[")){
	            str = stack.pop() + str;
	          }
	          stack.push(str);
	          str = "";
	        }
	      } else if(c == '['){
	        if(!num.equals("")){
	          if(!str.equals("")){
	            while (!stack.isEmpty() && !stack.peek().equals("[")){
	              str = stack.pop() + str;
	            }
	            stack.push(str);
	            str = "";
	          }
	          stack.push(num);
	          num = "";
	        }
	        stack.push(c + "");
	      } else if(c == ']'){
	        while (!stack.isEmpty() && !stack.peek().equals("[")){
	          str = stack.pop() + str;
	        }
	        String temp = str;
	        str = "";
	        stack.pop();
	        int freq = Integer.parseInt(stack.pop());
	        String temp1 = temp;
	        for(int j = 1; j < freq; j++){
	          temp1 += temp;
	        }
	        stack.push(temp1);
	      } else {
	        str += c;
	      }
	    }
	    if(!str.equals("")) stack.push(str);
	    String result = "";
	    while(!stack.isEmpty()){
	      result = stack.pop() + result;
	    }
	    return result;
	  }
	
	public static void main(String[] args) {
		Problem394 problem = new Problem394();
		//System.out.println(problem.decodeString("3[a]2[bc]"));
		//System.out.println(problem.decodeString("3[a2[c]]"));
		System.out.println(problem.decodeString("2[leetcode]"));
	}
}
