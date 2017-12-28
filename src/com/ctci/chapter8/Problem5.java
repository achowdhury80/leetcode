package com.ctci.chapter8;

/**
 * Created by ayanc on 7/23/17.
 */
public class Problem5 {
  public long multiply(int a, int b){
    if(a > b) return productHelper(b, a);
    return productHelper(a, b);
  }

  private long productHelper(int smaller, int bigger){
    if(smaller == 0) return 0;
    if(smaller == 1) return bigger;
    int half = smaller >> 1;
    long halfProduct = productHelper(half, bigger);
    if(smaller % 2 == 0) return halfProduct + halfProduct;
    return halfProduct + halfProduct + bigger;
  }

  public static void main(String[] args){
    System.out.println(new Problem5().multiply(5,4));
  }
}
