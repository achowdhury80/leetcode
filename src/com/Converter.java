package com;

/**
 * Created by ayanc on 6/3/17.
 */
@FunctionalInterface
public interface Converter<F, T> {
  T convert(F from);
  default void log(String msg){
    System.out.println(msg);
  }
}
