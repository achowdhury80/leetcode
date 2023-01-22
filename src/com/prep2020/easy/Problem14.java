package com.prep2020.easy;

public class Problem14 {
	/**
	 * O(N*minW) where n is number of words and minW is the minimum length of the words
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
        String result = "";
        int i = 0;
        boolean flag = true;
        while(flag) {
        	Character c = null;
        	for (String str : strs) {
        		if (str.length() == i) {
        			flag = false;
        			break;
        		}
        		if (c == null) c = str.charAt(i);
        		else if (c != str.charAt(i)) {
        			flag = false;
        			break;
        		}
        	}
        	if (flag) result += c;
        	i++;
        }
        return result;
    }
}
