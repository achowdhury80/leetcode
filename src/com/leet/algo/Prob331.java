package com.leet.algo;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob331 {

  public boolean isValidSerialization(String preorder) {
    if(preorder == null || preorder.length() == 0) return true;
    String[] arr = preorder.split(",");
    Integer result = validate(arr, 0);
    return result != null && result == arr.length;
  }

  private Integer validate(String[] arr, int start){
    if(start >= arr.length) return null;
    if(arr[start].equals("#")) return  start + 1;
    Integer newStart = validate(arr, start + 1);
    if(newStart == null) return null;
    return validate(arr, newStart);
  }

  public static void main(String[] args){
    Prob331 prob331 = new Prob331();
    System.out.println(prob331.isValidSerialization("9,#,#"));
    System.out.println(prob331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    System.out.println(prob331.isValidSerialization("1,#"));
    System.out.println(prob331.isValidSerialization("9,#,#,1"));
  }
}
