package com.prep2020.easy;

public class Problem67 {
	/**
	 * O(n1 + n2)
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0, sum = 0;
        while(i > -1 || j > -1) {
        	sum = carry;
        	if (i > -1) sum += (a.charAt(i--) - '0'); 
        	if (j > -1) sum += (b.charAt(j--) - '0');
        	carry = sum / 2;
        	result.insert(0, sum % 2);
        }
        if (carry > 0) result.insert(0, '1');
        return result.toString();
    }
}
