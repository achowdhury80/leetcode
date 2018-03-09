package com.leet.algo;

/**
 * Created by ayanc on 11/3/17.
 */
public class Prob12 {
  public String intToRoman(int num) {
    String[] M = new String[]{"", "M", "MM", "MMM"};
    String[] C = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] X = new  String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] I = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String result = "";
    if (num == 0) return result;
    return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
  }

  public static void main(String[] args){
    Prob12 prob12 = new Prob12();
    System.out.println(prob12.intToRoman(3999));

  }
}
