package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob640 {
  public String solveEquation(String equation) {
    if(equation == null || equation.length() < 3) return "No solution";
    if(equation.indexOf("=") < 1) return "No solution";
    String[] exprs = equation.split("=");
    if(exprs.length != 2) return "No solution";
    int[] left = evaluateExpr(exprs[0]);
    int[] right = evaluateExpr(exprs[1]);
    int xCoef = left[0] - right[0];
    int constants = right[1] - left[1];
    if(xCoef == 0){
      if(constants == 0) return "Infinite solutions";
      else return "No solution";
    }
    return "x=" + (constants / xCoef);
  }

  public int[] evaluateExpr(String s){
    List<String> list = new ArrayList<>();
    int last = 0;
    String sign = "";
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) == '-'){
        if(i != 0) {
          list.add(sign + s.substring(last, i));
        }
        sign = "-";
        last = i + 1;
      } else if(s.charAt(i) == '+'){
        list.add(sign + s.substring(last, i));
        sign = "";
        last = i + 1;
      }
    }
    list.add(sign + s.substring(last));
    int[] result = new int[2];
    for(int i = 0; i < list.size(); i++){
      String st = list.get(i);
      if(st.indexOf("x") > -1){
        if("x".equals(st)) result[0] += 1;
        else if("-x".equals(st)) result[0] += -1;
        else result[0] += Integer.parseInt(st.substring(0, st.length() - 1));
      }
      else result[1] += Integer.parseInt(st);
    }
    return result;
  }

  public static void main(String[] args){
    Prob640 prob640 = new Prob640();
    System.out.println(prob640.solveEquation("x+5-3+x=6+x-2"));
    System.out.println(prob640.solveEquation("x=x"));
    System.out.println(prob640.solveEquation("2x=x"));
    System.out.println(prob640.solveEquation("2x+3x-6x=x+2"));
    System.out.println(prob640.solveEquation("x=x+2"));
  }
}
