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
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[n];
    int previousTime = 0;
    for(String st : logs){
      String[] parts = st.split(":");
      if(!stack.isEmpty()) result[stack.peek()] += Integer.valueOf(parts[2]) - previousTime;
      previousTime = Integer.valueOf(parts[2]);
      if(parts[1].equals("start")){
        stack.push(Integer.parseInt(parts[0]));
      } else {
        result[stack.pop()]++;
        previousTime++;
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
