package com.leet.algo;

/**
 * Created by ayanc on 12/27/17.
 */
public class Prob686 {
  public int repeatedStringMatch(String A, String B) {
    if(A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
    int count = 0;
    StringBuilder sb = new StringBuilder("");
    while(B.length() > sb.toString().length()){
      count++;
      sb.append(A);
      if(sb.toString().indexOf(B) > -1) return count;
    }
    if(sb.append(A).toString().indexOf(B) > -1) return ++count;
    return -1;
  }

  public static void main(String[] args){
    Prob686 prob686 = new Prob686();
    System.out.println(prob686.repeatedStringMatch("abcd", "cdabcdab"));
  }
}
