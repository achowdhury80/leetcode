package com;

/**
 * Created by ayanc on 6/3/17.
 */
public interface Formula {
  double calculate(int a);
  default double sqrt(int a){
    return Math.sqrt(a);
  }
}
