package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob475 {
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int result = 0;
    int lastHeaterIndex = 0;
    for(int i = 0; i < houses.length; i++){
      int distance = Math.abs(heaters[lastHeaterIndex] - houses[i]);
      while(lastHeaterIndex < heaters.length - 1 && Math.abs(heaters[lastHeaterIndex + 1] - houses[i]) <= Math.abs(heaters[lastHeaterIndex] - houses[i]) ){
        lastHeaterIndex++;

      }
      distance = Math.abs(heaters[lastHeaterIndex] - houses[i]);
      result = Math.max(result, distance);
    }
    return result;
  }

  public static void main(String[] args){
    Prob475 prob475 = new Prob475();
    System.out.println(prob475.findRadius(new int[]{1, 2, 3}, new int[]{2}));
    System.out.println(prob475.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    System.out.println(prob475.findRadius(new int[]{25921153,510616708}, new int[]{771515668,357571490,44788124,927702196,952509530}));
    System.out.println(prob475.findRadius(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}));
  }
}
