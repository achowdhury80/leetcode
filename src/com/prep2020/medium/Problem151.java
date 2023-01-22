package com.prep2020.medium;

public class Problem151 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
       char[] arr = s.toCharArray();
       StringBuilder result = new StringBuilder();
       StringBuilder cur = new StringBuilder("");
       for (int i = 0; i < arr.length; i++) {
    	   if (arr[i] != ' ') {
    		   cur.append(arr[i]);
    	   } else {
    		   if (!cur.toString().equals("")) {
    			   result.insert(0, " " + cur.toString());
    			   cur  = new StringBuilder("");
    		   }
    	   }
       }
       if (!cur.toString().equals("")) {
		   result.insert(0, " " + cur.toString());
       }
       return result.substring(1);
    }
}
