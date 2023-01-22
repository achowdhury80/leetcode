package com.prep2020.medium;

import java.util.List;

public class Problem385 {
	public NestedInteger deserialize(String s) {
		if ("".equals(s) || "[]" .equals(s)) return new NestedInteger();
		int listStartIndex = s.indexOf('[');
		if (listStartIndex < 0) return new NestedInteger(Integer.parseInt(s));
		s = s.substring(1, s.length() - 1) + ",";
		int listStartCount = 0, start = 0;
		NestedInteger nestedInteger = new NestedInteger();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') listStartCount++;
			else if (c == ']') listStartCount--;
			if (c == ',' && listStartCount == 0) {
				nestedInteger.add(deserialize(s.substring(start, i)));
				start = i + 1;
			}
		}
        return nestedInteger;
    }
	
	public class NestedInteger {
		      // Constructor initializes an empty nested list.
		      public NestedInteger() {}
		 
		      // Constructor initializes a single integer.
		      public NestedInteger(int value) {}
		 
		      // @return true if this NestedInteger holds a single integer, rather than a nested list.
		      public boolean isInteger() {return false;}
		 
		      // @return the single integer that this NestedInteger holds, if it holds a single integer
		      // Return null if this NestedInteger holds a nested list
		      public Integer getInteger() {return 0;}
		 
		      // Set this NestedInteger to hold a single integer.
		      public void setInteger(int value) {}
		 
		      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
		      public void add(NestedInteger ni) {}
		 
		      // @return the nested list that this NestedInteger holds, if it holds a nested list
		      // Return empty list if this NestedInteger holds a single integer
		      public List<NestedInteger> getList(){return null;}
		  }
}
