package com.leet.algo;

/**
 * Created by ayanc on 9/13/17.
 */
public class Prob434 {
  public int countSegments(String s) {
    String[] arr = s.split(" ");
    int count = 0;
    for(String st : arr){
      if(!"".equals(st))count++;
    }
    return count;
  }

  public static void main(String[] args){
    Prob434 prob434 = new Prob434();
    System.out.println(prob434.countSegments(", , , ,        a, eaefa"));
  }
}
