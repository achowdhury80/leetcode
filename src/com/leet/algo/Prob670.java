package com.leet.algo;

/**
 * Created by ayanc on 1/9/18.
 */
public class Prob670 {
  public int maximumSwap(int num) {
    int[] bucket = new int[10];
    char[] arr = Integer.toString(num).toCharArray();
    for(int i = 0; i < arr.length; i++){
      bucket[arr[i] - '0'] = i;
    }
    for(int i = 0; i < arr.length; i++){
      for(int j = 9; j > arr[i] - '0'; j--){
        if(bucket[j] > i){
          char c = arr[i];
          arr[i] = arr[bucket[j]];
          arr[bucket[j]] = c;
          return Integer.valueOf(new String(arr));
        }
      }
    }
    return num;

  }
}
