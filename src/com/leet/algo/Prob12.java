package com.leet.algo;

/**
 * Created by ayanc on 11/3/17.
 */
public class Prob12 {
  public String intToRoman(int num) {
    String result = "";
    if(num == 0) return result;
    while(num / 1000 > 0){
      result += "M";
      num = num - 1000;
    }
    if(num >= 900){
      result += "CM";
      num -= 900;
    }
    if(num >= 500){
      result += "D";
      num -= 500;
    }
    if(num >= 400){
      result += "CD";
      num -= 400;
    }
    while(num >= 100){
      result += "C";
      num -= 100;
    }
    if(num >= 90){
      result += "XC";
      num -= 90;
    }
    if(num >= 50){
      result += "L";
      num -= 50;
    }
    if(num >= 40){
      result += "XL";
      num -= 40;
    }
    while(num >= 10){
      result += "X";
      num -= 10;
    }
    if(num >= 9){
      result += "IX";
      num -= 9;
    }
    if(num >= 5){
      result += "V";
      num -= 5;
    }
    if(num >= 4){
      result += "IV";
      num -= 4;
    }
    while(num > 0){
      result += "I";
      num -= 1;
    }
    return result;

  }

  public static void main(String[] args){
    Prob12 prob12 = new Prob12();
    System.out.println(prob12.intToRoman(3999));
  }
}
