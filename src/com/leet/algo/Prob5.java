package com.leet.algo;

/**
 * Created by ayanc on 12/29/17.
 */
public class Prob5 {
  public String longestPalindrome(String s) {
    if(s == null || s.length() == 0) return "";
    if(s.length() == 1) return s;
    boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
    String result = s.charAt(0) + "";
    for(int i = 1; i <= s.length(); i++){
      dp[i][i] = true;
    }
    for(int j = 1; j < s.length(); j++){
      for(int i = 1; i < s.length(); i++){
        if(i + j > s.length()) continue;
        if(s.charAt(i - 1) == s.charAt(i + j - 1)){
          if(j == 1 || dp[i + 1][i + j - 1]) {
            dp[i][i + j] = true;
            if(j + 1 > result.length()){
              result = s.substring(i - 1, i + j);
            }
          } else {
            dp[i][i + j] = false;
          }

        } else {
          dp[i][i + j] = false;
        }
      }
    }
    //String result = longestPalindrome(dp, s, 0, s.length() - 1);
    return result;
  }

//  private String longestPalindrome(String[][]dp, String s, int start, int end){
//    if(start == end){
//      dp[start][end] = s.charAt(start) + "";
//      return dp[start][end];
//    }
//    if(start > end) return null;
//    if(dp[start][end] != null) return dp[start][end];
//    if(start + 1 == end) {
//      if(s.charAt(start) == s.charAt(end)){
//        dp[start][end] = s.charAt(start) + "" + s.charAt(end);
//      } else dp[start][end] = s.charAt(start) + "";
//      return dp[start][end];
//    }
//    if(s.charAt(start) == s.charAt(end)){
//      String longest = longestPalindrome(dp, s, start + 1, end - 1);
//      if(longest.length() + 2 == end - start + 1){
//        dp[start][end] = s.charAt(start) + longest + s.charAt(end);
//      } else {
//        String leftLongest = longestPalindrome(dp, s, start, end - 1);
//        String rightLongest = longestPalindrome(dp, s, start + 1, end);
//        if(leftLongest.length() > rightLongest.length()){
//          if (leftLongest.length() > longest.length()){
//            dp[start][end] = leftLongest;
//          } else {
//            dp[start][end] = longest;
//          }
//        } else {
//          if (rightLongest.length() > longest.length()){
//            dp[start][end] = rightLongest;
//          } else {
//            dp[start][end] = longest;
//          }
//        }
//      }
//      return dp[start][end];
//    } else {
//      String leftLongest = longestPalindrome(dp, s, start, end - 1);
//      String rightLongest = longestPalindrome(dp, s, start + 1, end);
//      if(leftLongest.length() > rightLongest.length()){
//        dp[start][end] = leftLongest;
//      } else dp[start][end] = rightLongest;
//      return dp[start][end];
//    }
//  }

  public static void main(String[] args){
    Prob5 prob5 = new Prob5();
    System.out.println(prob5.longestPalindrome("babad"));
    System.out.println(prob5.longestPalindrome("cbbd"));
    System.out.println(prob5.longestPalindrome("bb"));
  }
}
