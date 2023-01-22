package com.prep2020.easy;

public class Problem1694 {
	/**
	 * O(N)
	 * @param number
	 * @return
	 */
	public String reformatNumber(String number) {
        String block = "";
        String result = "";
        for (char c : number.toCharArray()) {
        	if (c >= '0' && c <= '9') block += c;
        	if (block.length() == 3) {
        		result += "-" + block;
        		block = "";
        	}
        }
        if (block.length() == 1) {
        	result = result.substring(0, result.length() - 1) 
        			+ "-" + result.substring(result.length() - 1) + block;
        }else if (block.length() > 1) result += "-" + block;
        return result.substring(1);
    }
}
