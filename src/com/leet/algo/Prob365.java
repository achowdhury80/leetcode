package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ayanc on 1/24/18.
 */
public class Prob365 {
  public boolean canMeasureWater(int x, int y, int z) {
    if(z > x + y) return false;
    if(z == x || z == y || z == x + y) return true;
    return z % gcd(x, y) == 0;
  }

  private int gcd(int x, int y){
    while(x != 0){
      int temp = x;
      x = y % x;
      y = temp;
    }
    return y;
  }



  public static void main(String[] args){
    Prob365 prob365 = new Prob365();
    System.out.println(prob365.canMeasureWater(3, 5, 4));
    System.out.println(prob365.canMeasureWater(2, 6, 5));

  }
}
