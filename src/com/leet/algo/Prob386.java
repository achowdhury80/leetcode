package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob386 {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> list = new ArrayList<>();
    if(n < 1) return list;
    list.add(1);
    if(n == 1)return list;
    int last = 1;
    for(int i = 2; i <= n; i++){
      last = nextNumber(last, n);
      list.add(last);
    }
    return list;
  }

  private int nextNumber(int i, int max){
    if(i * 10 <= max) return i * 10;
    if((i + 1) % 10 == 0) {
      int j = i + 1;
      while(j % 10 == 0){
        j = j / 10;
      }
      return j;
    }
    if(i + 1 <= max) return i + 1;
    int j = i / 10 + 1;
    while(j % 10 == 0){
      j = j / 10;
    }
    return j;
  }


  public static void main(String[] args){
    Prob386 prob386 = new Prob386();
    System.out.println(prob386.lexicalOrder(13));
    System.out.println(prob386.lexicalOrder(34));
    List<Integer> list = prob386.lexicalOrder(192);
    System.out.println(list.size());
    System.out.println(list);
  }
}
