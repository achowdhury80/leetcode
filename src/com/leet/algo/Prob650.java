package com.leet.algo;

/**
 * Created by ayanc on 12/11/17.
 */
public class Prob650 {



  public int minSteps(int n) {
    if(n == 1) return 0;
    int[] steps = new int[n + 1];
    steps[1] = 0;
    for(int i = 2; i <= n; i++){
      for(int j = i / 2; j > 0; j--){
        if(i % j == 0){
          steps[i] = steps[j] + 1 + (i - j) / j ;
          break;
        }
      }
    }
    return steps[n];

  }

  public static void main(String[] arhs){
    Prob650 prob650 = new Prob650();
    System.out.println(prob650.minSteps(50));
    System.out.println(prob650.minSteps(3));
  }
}
