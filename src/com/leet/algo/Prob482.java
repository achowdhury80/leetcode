package com.leet.algo;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob482 {
  public String licenseKeyFormatting(String S, int K) {
    if(S == null || S.length() == 0 || K == 0) return "";
    char[] arr = new char[S.length() + S.length() / K + 1];

    for(int i = arr.length - K - 1; i > -1; i -= (K + 1)){
      arr[i] = '-';
    }
    int j = arr.length - 1;
    for(int i = S.length() - 1; i > -1; i--){
      char c = S.charAt(i);
      if(c == '-') continue;
      c = Character.toUpperCase(c);
      arr[j] = c;
      j--;
      if(arr[j] == '-') j--;
    }
    if(j == arr.length - 1) return "";
    j++;
    if(arr[j] == '-') j++;
    return String.copyValueOf(arr, j, arr.length - j);
  }

  public static void main(String[] args){
    Prob482 prob482 = new Prob482();
    //System.out.println(prob482.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    System.out.println(prob482.licenseKeyFormatting("---", 3));
  }
}
