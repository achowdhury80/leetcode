package com.prep2020.easy;

public class Problem157 {
	/**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] tempBuff = new char[4];
        int read = 0, idx = 0;
        boolean eof = false;
        while(read < n && !eof) {
        	int count = read4(tempBuff);
        	if (count < 4) {
        		eof = true;
        	}
        	if (read + count >= n) {
        		count = n - read;
        		read = n;
        	}
        	else read += count;
        	for (int i = 0; i < count; i++) {
        		buf[idx++] = tempBuff[i];
        	}
        	
        }
        return read;
    }
    
    int read4(char[] buf4) {
    	return 0;
    }
}
