package com.leet.algo;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob393 {
  public boolean validUtf8(int[] data) {
    if(data == null || data.length < 0) return false;
    for(int j = 0; j < data.length; j++){
      int i = data[j];
      i = (i & 255);
      int numberOfBytes = findNoOfBytes(i);
      if(numberOfBytes < 1) return false;
      if(numberOfBytes == 1) continue;
      for(int k = 1; k < numberOfBytes; k++){
        j++;
        if(j >= data.length) return false;
        i = data[j];
        i = (i & 255);
        if(i > 191 || i < 128) return false;
      }
    }
    return true;
  }

  private int findNoOfBytes(int i){
    if(i < 128) return 1;
    if(i > 191 & i < 224) return 2;
    if(i > 223 & i < 240) return 3;
    if(i > 239 & i < 248) return 4;
    return 0;
  }

  public static void main(String[] args){
    Prob393 prob393 = new Prob393();
    System.out.println(prob393.validUtf8(new int[]{197, 130, 1}));
    System.out.println(prob393.validUtf8(new int[]{235, 140, 4}));
  }


}
