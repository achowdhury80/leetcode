package com.leet.algo;

/**
 * Created by ayanc on 12/11/17.
 */
public class Prob647 {
  public int countSubstrings(String s) {
    int length = -1;
    if(s == null || (length = s.length()) == 0) return 0;
    int[][] counts = new int[length][length];
    int result = 0;
    for(int i = 0; i < length; i++){
      counts[i][i] = 1;
      result++;
      for(int j = i + 1; j < length; j++){
        if(isPalindrom(s, i, j)) {
          counts[i][j] = counts[i][j - 1] + 1;
          result++;
        }
      }
    }
    return result;
  }

  private boolean isPalindrom(String s, int i, int j){
    String actual = s.substring(i, j + 1);
    return actual.equals(new StringBuilder(actual).reverse().toString());
  }

  public static void main(String[] args){
    Prob647 prob647 = new Prob647();
    System.out.println(prob647.countSubstrings("abc"));
    System.out.println(prob647.countSubstrings("aaa"));
  }
}
