package com.prep2020.hard;
import java.util.*;
public class Problem158 {
	private boolean eof = false;
	private List<Character> previousChars = new ArrayList<>();
	/**
	 * O(N)
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
    	int idx = -1, result = 0;
    	while(!previousChars.isEmpty() && n > 0) {
    		buf[++idx] = previousChars.remove(0);
    		n--;
    		result++;
    	}
    	if (n == 0 || eof) return result;
        while(n > 0 && !eof) {
        	char[] arr = new char[4];
        	int readChars = read4(arr);
        	if (readChars < 4) eof = true;
        	for (int j = 0; j < readChars; j++) {
        		if (n > 0) {
        			buf[++idx] = arr[j];
        			result++;
        			n--;
        		} else previousChars.add(arr[j]);
        	}
        }
        return result;
    }
    
    private int read4(char[] buf) {
    	return 0;
    }
}
