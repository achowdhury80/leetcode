package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob241 {
  public List<Integer> diffWaysToCompute(String input) {
    List<String> list = new ArrayList<>();
    int lastIndex = -1;
    String s;
    while((s = next(input, lastIndex)) != null){
      lastIndex += s.length();
      list.add(s);
    }
    return evaluate(list, 0);
  }

  private List<Integer> evaluate(List<String> list, int start){
    List<Integer> result = new ArrayList<>();
    int first = Integer.parseInt(list.get(start));
    if(list.size() == start + 1) {
      result.add(first);
      return result;
    }
    int second = Integer.parseInt(list.get(start + 2));
    String op = list.get(start + 1);
    int firstN2nd = evaluate(first, op, second);
    if(list.size() == start + 3) {
      result.add(firstN2nd);
      return result;
    }
    List<Integer> result1 = evaluate(list, start + 2);
    List<Integer> result2 = evaluate(list, start + 4);
    for(int r : result1){
      result.add(evaluate(first, op, r));
    }
    for(int r : result2){
      result.add(evaluate(firstN2nd, list.get(start + 3), r));
    }
    return result;
  }



  private Integer evaluate(int first, String op, int last){
    if(op.equals("+")) return first + last;
    if(op.equals("*")) return first * last;
    return first - last;
  }

  private String next(String input, int lastIndex){
    if(lastIndex == input.length() - 1) return null;
    String result = "";
    for(int i = lastIndex + 1; i < input.length() ; i++){
      char c = input.charAt(i);
      if(c == '+' || c == '-' || c == '*'){
        if(result.equals("")) return "" + c;
        else return result;
      } else result += c;
    }
    return result;
  }

  public static void main(String[] args){
    Prob241 prob241 = new Prob241();
    System.out.println(prob241.diffWaysToCompute("2-1-1"));
    System.out.println(prob241.diffWaysToCompute("2*3-4*5"));
  }
}
