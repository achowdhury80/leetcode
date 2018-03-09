package com.leet.algo;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob6 {
  // every rows column delta is {2n -2, 0}, {2n - 4, 2}, {2n - 6, 4}}...{4, 2n -6}, {2, 2n -4}, {0, 2n -2}
  public String convert(String s, int numRows) {
    if(s == null || s.length() == 0 || numRows < 1) return "";
    if(numRows == 1) return s;
    String result = "";
    int[] delta = new int[]{2 * numRows - 2, 0};
    for (int i = 0; i < numRows; i++) {
      int cur = 0;
      int j = i;
      while (j < s.length()) {
        result += s.charAt(j);
        if (delta[cur] == 0) cur = (cur + 1) % 2;
        j += delta[cur];
        cur = (cur + 1) % 2;
      }
      delta[0] -= 2;
      delta[1] += 2;
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
