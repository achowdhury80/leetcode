package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob168 {
  public String convertToTitle(int n) {
    if(n < 1) return null;
    StringBuilder result = new StringBuilder();
    while(n > 0) {
    	n--;
    	int rem = n % 26;
    	result.insert(0, (char) (rem + 65));
    	n /= 26;
    }
    return result.toString();
  }
}
