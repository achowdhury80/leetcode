package com.leet.algo;

/**
 * Created by ayanc on 11/15/17.
 */
public class Prob260 {
  public int[] singleNumber(int[] nums) {
    int temp = 0;
    for(int i = 0; i < nums.length; i++){
      temp ^= nums[i];
    }
    String binaryString = Integer.toBinaryString(temp);
    int pos = -1;
    for(int i = binaryString.length() - 1; i > -1; i--){
      if(binaryString.charAt(i) == '1') {
        break;
      }
      pos--;
    }
    int result1 = 0;
    int result2 = 0;
    for(int i = 0; i < nums.length; i++){
      String st = Integer.toBinaryString(nums[i]);
      if(st.length() + pos > -1 && st.charAt(st.length() + pos) == '1') result1 ^= nums[i];
      else result2 ^= nums[i];
    }
    return new int[]{result1, result2};
  }
  public static void main(String[] args){
    Prob260 prob260 = new Prob260();
    int[] result = prob260.singleNumber(new int[]{1,2,1,3,2,5});
    System.out.println(result[0] +", " + result[1]);
  }
}
