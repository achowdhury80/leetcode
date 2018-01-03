package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by ayanc on 1/2/18.
 */
public class Prob636 {
  public int[] exclusiveTime(int n, List<String> logs) {
    if(logs == null || logs.size() < 2) return new int[0];
    Stack<String> stack = new Stack<>();
    int[] result = new int[logs.size() / 2];
    for(String st : logs){
      if(!st.contains(":end:")){
        if(stack.isEmpty()) stack.push(st);
        else {
          String[] peekStr = stack.peek().split(":");
          String[] arr = st.split(":");
          stack.push(peekStr[0] + ":end:" + (Integer.valueOf(arr[2]) - 1));
          stack.push(st);

        }
      } else {
        String[] arrEnd = st.split(":");
        String[] arrStart = stack.pop().split(":");
        result[Integer.parseInt(arrEnd[0])] += Integer.valueOf(arrEnd[2]) - Integer.valueOf(arrStart[2]) + 1;
        if(!stack.isEmpty()){
          String[] peekStr = stack.peek().split(":");
          String[] arr = st.split(":");
          stack.push(peekStr[0] + ":end:" + (Integer.valueOf(arr[2]) - 1));
          stack.push(st);
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob636 prob636 = new Prob636();
    List<String> input = new ArrayList<>();
    input.add("0:start:0");
    input.add("1:start:2");
    input.add("1:end:5");
    input.add("0:end:6");
    int[] result = prob636.exclusiveTime(2, input);
    Arrays.stream(result).forEach(x -> System.out.println(x));
  }
}
