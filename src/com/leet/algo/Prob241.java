package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob241 {
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i < input.length(); i++){
      char c = input.charAt(i);
      if(c == '+' || c == '-' || c == '*'){
        List<Integer> left = diffWaysToCompute(input.substring(0, i));
        List<Integer> right = diffWaysToCompute(input.substring(i + 1));
        for (Integer i1 : left){
          for (Integer i2 : right){
            if(c == '+') result.add(i1 + i2);
            else if(c == '-') result.add(i1 - i2);
            else result.add(i1 * i2);
          }
        }
      }
    }
    if (result.size() < 1) result.add(Integer.parseInt(input));
    return result;
  }


  public static void main(String[] args){
    Prob241 prob241 = new Prob241();
    System.out.println(prob241.diffWaysToCompute("2-1-1"));
    System.out.println(prob241.diffWaysToCompute("2*3-4*5"));
  }
}
