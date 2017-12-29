package com.leet.algo;

/**
 * Created by ayanc on 12/29/17.
 */
public class Prob165 {
  public int compareVersion(String version1, String version2) {
    String[] arr1 = version1.split("\\.");
    String[] arr2 = version2.split("\\.");
    int min = arr1.length > arr2.length ? arr2.length : arr1.length;
    for(int i = 0; i < min; i++){
      int i1 = Integer.valueOf(arr1[i]);
      int i2 = Integer.valueOf(arr2[i]);
      if(i1 > i2) return 1;
      if(i1 < i2) return -1;
    }
    if(arr1.length > min){
      for(int i = min; i < arr1.length; i++){
        if(Integer.valueOf(arr1[i]) > 0) return 1;
      }
    }
    if(arr2.length > min) {
      for(int i = min; i < arr2.length; i++){
        if(Integer.valueOf(arr2[i]) > 0) return -1;
      }
    }
    return 0;
  }

  public static void main(String[] args){
    Prob165 prob165 = new Prob165();
    System.out.println(prob165.compareVersion("1.1", "1.2"));
    System.out.println(prob165.compareVersion("1.0", "1"));
  }
}
