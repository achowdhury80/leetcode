package com.prep2020.easy;

public class Problem1108 {
	/**
	 * O(N)
	 * @param address
	 * @return
	 */
	public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();
        for (char c : address.toCharArray()) {
        	if (c == '.') result.append("[.]");
        	else result.append(c);
        }
        return result.toString();
    }
}
