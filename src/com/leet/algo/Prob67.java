package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob67 {
  public String addBinary(String a, String b) {
    if(a == null || a.length() == 0 || b == null || b.length() == 0) return null;
    String result = "";
    int aLength = a.length();
    int bLength = b.length();
    int maxLength = aLength > bLength ? aLength : bLength;
    int carry = 0;
    for(int i = 0; i < maxLength; i++){
      int aVal = (int)(i < aLength ? a.charAt(aLength - i - 1) : '0') - '0';
      int bVal = (int)(i < bLength ? b.charAt(bLength - i - 1) : '0') - '0';
      result = "" + ((aVal + bVal + carry) % 2 == 0 ? 0 : 1) + result;
      carry = (aVal + bVal + carry) > 1 ? 1 : 0;
    }
    if(carry == 1) result = "1" + result;
    return result;

  }
}
