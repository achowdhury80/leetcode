package com.leet.algo;

/**
 * Created by ayanc on 9/12/17.
 */
public class Prob492 {

  public int[] constructRectangle(int area) {
    int sqrtCeil = Double.valueOf(Math.ceil(Math.sqrt(area))).intValue();
    for(int i = sqrtCeil; i <= area / 2 ; i++){
      if(area % i == 0){
        return new int[]{i, area / i};
      }
    }
    return null;
  }
  public static void main(String [] args){
    Prob492 prob492 = new Prob492();
    int[] arr = prob492.constructRectangle(98);
    System.out.println(arr[0] + ", " + arr[1]);
  }
}
