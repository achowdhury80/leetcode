package com.leet.algo;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob43Gaussian {
  public String multiply(String num1, String num2) {
    if(num1 == null || num1.equals("0") || num2 == null || num2.equals("0")) return "0";
    String result = multiplyStrings(num1, num2);
    while(result.startsWith("0")) result = result.substring(1);
    return result;
  }

  private String multiplyStrings(String x, String y){
    int maxLength = x.length();
    int zerosToAdd = 0;
    if(y.length() > maxLength){
      zerosToAdd = y.length() - x.length();
      for(int i = 0; i < zerosToAdd; i++){
        x = '0' + x;
      }
    } else {
      zerosToAdd = x.length() - y.length();
      for(int i = 0; i < zerosToAdd; i++){
        y = '0' + y;
      }
    }
    if(x.length() == 1){
      return String.valueOf(Integer.valueOf(x) * Integer.valueOf(y));
    }
    int mid = x.length() / 2;
    int n = x.length() - mid;
    String a = x.substring(0, mid);
    String b = x.substring(mid);
    String c = y.substring(0, mid);
    String d = y.substring(mid);
    String ac = multiplyStrings(a, c);
    String bd = multiplyStrings(b, d);
    String aPlusB = add(new String[]{a, b});
    String cPlusD = add(new String[]{c, d});
    String aPlusBCPlusD = multiplyStrings(aPlusB, cPlusD);
    String result = add(new String[]{shiftLeft(ac, n * 2), bd, shiftLeft(subtract(subtract(aPlusBCPlusD, ac), bd), n)});
    return result;
  }

  private String add(String[] arr){
    String result = arr[0];
    for(int i = 1; i < arr.length; i++){
      result = add(result, arr[i]);
    }
    return result;
  }

  public String add(String a, String b){
    while(a.length() > b.length()){
      b = "0" + b;
    }
    while(b.length() > a.length()){
      a = "0" + a;
    }
    int carry = 0;
    String result = "";
    for(int i = a.length() - 1; i > -1; i--){
      int temp = Integer.valueOf(a.charAt(i) + "") + Integer.valueOf(b.charAt(i) + "") + carry;
      carry = 0;
      if(temp > 9){
        carry = 1;
        temp = temp - 10;
      }
      result = temp + result;
    }
    if(carry != 0) result = carry + result;
    return result;
  }

  private String subtract(String a, String b){
    while(a.length() > b.length()){
      b = "0" + b;
    }
    while(b.length() > a.length()){
      a = "0" + a;
    }
    int carry = 0;
    String result = "";
    for(int i = a.length() - 1; i > -1; i--){
      int toBeSubtracted = Integer.valueOf(b.charAt(i) + "") + carry;
      carry = 0;
      int aNum = Integer.valueOf(a.charAt(i) + "");
      if(aNum < toBeSubtracted){
        aNum += 10;
        carry = 1;
      }
      int temp = aNum - toBeSubtracted;
      result = temp + result;
    }
    return result;
  }
  private String shiftLeft(String s, int n){
    String result = s;
    for(int i = 1; i <= n; i++){
      result = result + '0';
    }
    return result;
  }


  public static void main(String[] args){
    Prob43Gaussian prob43 = new Prob43Gaussian();
    System.out.println(prob43.multiply("1111", "1111"));
    System.out.println(prob43.multiply("11", "111"));
    System.out.println(prob43.multiply("123", "456"));
    System.out.println(prob43.multiply("98", "9"));
    System.out.println(prob43.multiply("6", "501"));
  }
}
