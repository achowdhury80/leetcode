package com;

/**
 * Created by ayanc on 6/3/17.
 */
public interface ConverterMulti<A,B,C> {
  C convert(A a, B b);
}
