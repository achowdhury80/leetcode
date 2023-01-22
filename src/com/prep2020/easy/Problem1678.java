package com.prep2020.easy;

public class Problem1678 {
	/**
	 * O(N)
	 * @param command
	 * @return
	 */
	public String interpret(String command) {
		StringBuilder sb = new StringBuilder();
		String last = "";
        for (char c : command.toCharArray()) {
        	if (c == '(') {
        		last = "";
        	} else if (c == ')') {
        		if (last.equals("")) sb.append('o');
        		else {
        			sb.append(last);
        			last = "";
        		}
        	} else if (c == 'G') sb.append('G');
        	else last = last + c;
        }
        return sb.toString();
    }
}
