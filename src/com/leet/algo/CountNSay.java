package com.leet.algo;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.
 */
public class CountNSay {
    public String countAndSay(int n) {
      if(n < 1) return null;
      if(n == 1) return "1";
      String numberString = countAndSay(n - 1);
      return say(numberString);
    }

    private String say(String numberString){
      String result = "";
      int i = 0;
      String currentNumber = "";
      int count = 0;
      while(i < numberString.length()){
        currentNumber = "" + numberString.charAt(i);
        count++;
        if(i > numberString.length() - 2 || !currentNumber.equals("" + numberString.charAt(i + 1))){
          result += count + currentNumber;
          count = 0;
        }
        i++;
      }
      return result;
    }

  public static void main(String[] args){
    CountNSay countNSay = new CountNSay();
    System.out.println(countNSay.countAndSay(15));
  }
}
