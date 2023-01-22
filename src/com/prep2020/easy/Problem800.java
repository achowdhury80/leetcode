package com.prep2020.easy;

public class Problem800 {
	public String similarRGB(String color) {
	    String result = "#";
	    String[] parts = new String[3];
	    for (int i = 1; i < 7; i += 2) {
	      parts[i / 2] = color.substring(i, i + 2);
	    }
	    for (int i = 0; i < 3; i++) result += findNearest(parts[i]);
	    return result;
	  }

	  private String findNearest(String part) {
	    char c = part.charAt(0);
	    if (c == part.charAt(1)) return part;
	    String result = c + "" + c;
	    int curVal = computeVal(part);
	    int diff = Math.abs(computeVal(result) - curVal);
	    char nextChar = c == 'f' ? '0' : (c == '9' ? 'a' :(char)(c + 1));
	    if (Math.abs(computeVal(nextChar + "" + nextChar) - curVal) < diff) {
	      result = nextChar + "" + nextChar;
	      diff = computeVal(nextChar + "" + nextChar) - curVal;
	    }
	    char prevChar = c == '0' ? 'f' : (c == 'a' ? '9' : (char)(c - 1));
	    if (Math.abs(computeVal(prevChar + "" + prevChar) - curVal) < diff) {
	      result = prevChar + "" + prevChar;
	    }
	    return result;
	  }

	  private int computeVal(String part) {
	    return 16 * getVal(part.charAt(0)) + getVal(part.charAt(1));
	  }

	  private int getVal(char c) {
	    if (c >= '0' && c <= '9') return c -'0';
	    return c - 'a' + 10;
	  }
}
