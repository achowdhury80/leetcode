package com.leet.algo;

public class Prob880 {
	public String decodeAtIndex(String S, int K) {
        long len = 0;
        char lastC = '0';
        for (char c : S.toCharArray()) {
        	if (Character.isLetter(c)) {
        		if (++len == K) return "" + c;
        		lastC = c;
        	}
        	else {
        		long m = len * (c - '0');
        		if (m == K) return "" + lastC;
        		if (m > K) {
        			// check whether last length = k
        			if (K % len == 0) return "" + lastC;
        			// now we know, last formed string will be repeated some times
        			// and our target is within that target. we don't need to bother about what comes after
        			return decodeAtIndex(S, (int)(K % len));
        		}
        		len = m;
        	}
        }
        return "";
    }
}
