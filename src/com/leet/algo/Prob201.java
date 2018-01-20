package com.leet.algo;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob201 {
  public int rangeBitwiseAnd(int m, int n) {
    if(m == 0) return 0;
    if(m == n) return m;
    if(m + 1 == n) return m & n;
    int result = 0;
    m = m << 1;
    n = n << 1;
    boolean zeroed = false;
    int topMost1 = 1 << 31;
    for(int i = 0; i < 31; i++){
      result = result << 1;
      if(!zeroed){
        if((topMost1 & m) == (topMost1 & n)){
          if(topMost1 == (topMost1 & m))
            result += 1;
        } else {
          zeroed = true;
        }
      }
      m = m << 1;
      n = n << 1;
    }
    return result;
  }

  public static void main(String[] args){
    Prob201 prob201 = new Prob201();
    System.out.println(prob201.rangeBitwiseAnd(5, 7));
  }
}
