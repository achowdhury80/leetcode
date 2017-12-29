package com.leet.algo;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob6 {
  public String convert(String s, int numRows) {
    if(s == null || s.length() == 0 || numRows < 1) return "";
    if(numRows == 1) return s;
    int[][] dp = new int[numRows - 2][2];
    int midRangeForTwo = 2 * numRows - 2;
    int startGap = midRangeForTwo - 2;
    for(int i = 0; i < dp.length; i++){
      dp[i][0] = startGap;
      dp[i][1] = midRangeForTwo - startGap;
      startGap -= 2;
    }
    String result = "";
    for(int i = 0; i < numRows; i++){
      if(i == 0 || i == numRows - 1){
        int increment = 2 * numRows - 2;
        for(int j = i; j < s.length(); j = j + increment){
          result += s.charAt(j);
        }
      } else {
        int incrementIndex = 1;
        for(int j = i; j < s.length(); j = j + dp[i - 1][incrementIndex]){
          result += s.charAt(j);
          incrementIndex ^= 1;
        }
      }

    }
    return result;
  }

  public static void main(String[] args){
    Prob6 prob6 = new Prob6();
    System.out.println(prob6.convert("PAYPALISHIRING", 3));
    System.out.println(prob6.convert("ABCDEF", 7));
    System.out.println(prob6.convert("ABCD", 4));

  }
}
