package com.leet.algo;

import com.sun.istack.internal.ByteArrayDataSource;

/**
 * Created by ayanc on 11/6/17.
 */
public class Prob137 {
  public int singleNumber(int[] nums) {
    int[] digitsCount = new int[32];
    for(int i = 0; i < nums.length; i++){
      String binaryStr = Integer.toBinaryString(nums[i]);
      //System.out.println(binaryStr);
      for(int j = binaryStr.length() - 1; j > -1; j--){
        int digitIndex = binaryStr.length() - j - 1;
        if(binaryStr.charAt(j) == '0') continue;
        if(digitsCount[digitIndex] > 1){
          digitsCount[digitIndex] = 0;
        }else{
          digitsCount[digitIndex]++;
        }
      }
    }


    return findValue(digitsCount);
  }

  public static void main(String[] args){
    Prob137 prob137 = new Prob137();
    System.out.println(prob137.singleNumber(new int[]{1,3,2,4,2,3,1}));
  }

  public int findValue(int[] vals){
    String digitsCount = "";
    for(int i = 0; i < vals.length; i++){
      digitsCount += String.valueOf(vals[i]);
    }
    //System.out.println(digitsCount);
    if(digitsCount.charAt(0) == '0') return Integer.valueOf(digitsCount);
    boolean found1 = false;
    String s = "";
    for(int i = 31; i > 0; i--){
      if(!found1){
        s = digitsCount.charAt(i) + s;
        if(digitsCount.charAt(i) == '1') found1 = true;
      } else {
        s = (digitsCount.charAt(i) == 1 ? '0' : '1') + s;
      }
    }
    System.out.println(s);
    return Integer.valueOf(s);
  }
}
