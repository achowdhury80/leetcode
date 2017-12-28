package com;

/**
 * Created by ayanc on 6/3/17.
 */
public class ConverterMultiImpl implements ConverterMulti<String, String, String> {
  @Override
  public String convert(String a, String b) {
    return b + a;
  }
}
