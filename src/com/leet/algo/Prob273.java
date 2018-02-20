package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/19/18.
 */
public class Prob273 {
  private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
  public String numberToWords(int num) {
    if (num == 0) return "Zero";
    int i = 0;
    String result = "";
    while (num > 0) {
      if (num % 1000 != 0) result = helper(num % 1000) + THOUSANDS[i] + " " + result;
      num = num / 1000;
      i++;
    }
    return result.trim();
  }

  // below thousand
  private String helper(int num) {
    String result = "";
    if (num == 0) return "";
    if (num < 20) return LESS_THAN_20[num] + " ";
    if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
    else return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
  }

  public static void main(String[] args) {
    Prob273 prob273 = new Prob273();
    System.out.println(prob273.numberToWords(123));
    System.out.println(prob273.numberToWords(12345));
  }
}
