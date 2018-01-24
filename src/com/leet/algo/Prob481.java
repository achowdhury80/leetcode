package com.leet.algo;

/**
 * Created by ayanc on 1/23/18.
 */
public class Prob481 {

  public int magicalString(int n) {
    if(n == 0) return 0;
    if(n <= 3) return 1;
    int count = 1;
    int[] arr = new int[n + 1];

    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 2;
    int tail = 3;
    int generator = 2;
    int num = 1;
    while (tail < n){
      for(int i = 0; i < arr[generator]; i++){
        arr[tail] = num;
        if(num == 1 && tail < n) count++;
        tail++;
      }
      generator++;
      num ^= 3;
    }

    return count;
  }


  public static void main(String[] args){
    Prob481 prob481 = new Prob481();
    System.out.println(prob481.magicalString(6));
    System.out.println(prob481.magicalString(4));
  }
}
