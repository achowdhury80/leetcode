package com.leet.algo;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob738 {
  public int monotoneIncreasingDigits(int N) {
    if(N < 10) return N;
    String s = "" + N;
    int length = s.length();
    char firstChar = s.charAt(0);
    s = "";
    for(int i = 0; i < length; i++){
      s += firstChar;
    }
    int newNum = Integer.parseInt(s);
    String result = "";
    if(newNum > N){
      int leftMost =  Integer.parseInt("" + s.charAt(0)) - 1;
      for(int i = 1; i < length; i++){
        result += '9';
      }
      if(leftMost != 0) return Integer.parseInt(leftMost + result);
      else return Integer.parseInt(result);
    } else {
      if(newNum == N) return N;
      return Integer.parseInt(firstChar + "" + monotoneIncreasingDigits(Integer.parseInt(String.valueOf(N).substring(1))));
    }
  }

  public static void main(String[] args){
    Prob738 prob738 = new Prob738();
    System.out.println(prob738.monotoneIncreasingDigits(10));
    System.out.println(prob738.monotoneIncreasingDigits(1234));
    System.out.println(prob738.monotoneIncreasingDigits(332));
  }
}
