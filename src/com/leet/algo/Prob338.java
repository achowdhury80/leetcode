package com.leet.algo;

/**
 * Created by ayanc on 11/13/17.
 */
public class Prob338 {
  public int[] countBits(int num) {
    if(num < 0) return null;
    int[] result = new int[num + 1];
    result[0] = 0;
    if(num == 0) return result;
    result[1] = 1;
    for(int i = 2; i <= num; i=i*2){
      for(int j = 0; j < i && (i + j) <= num; j++){
        result[i + j] = 1 + result[j];
      }
    }
    return result;
  }
  public static void main(String[] args){
    Prob338 prob338 = new Prob338();
    prob338.showArray(prob338.countBits(4));
  }

  private void showArray(int[] nums){
    for(int i = 0; i < nums.length; i++){
      System.out.print(nums[i] + ", ");
    }
    System.out.println();
  }
}
