package com.leet.algo;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob717 {
  public boolean isOneBitCharacter(int[] bits) {
    if(bits == null || bits.length == 0) return false;
    if(bits.length < 2) return true;
    boolean result = false;
    for(int i = 0; i < bits.length; i++){
      if(bits[i] == 1) {
        result = false;
        i++;
      } else {
        result = true;
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob717 prob717 = new Prob717();
    System.out.println(prob717.isOneBitCharacter(new int[]{1, 0, 0}));
    System.out.println(prob717.isOneBitCharacter(new int[]{1, 1, 1, 0}));
  }
}
