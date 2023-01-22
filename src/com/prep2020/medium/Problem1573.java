package com.prep2020.medium;

public class Problem1573 {
	public int numWays(String s) {
        int oneCount = 0, n = s.length();
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == '1') oneCount++;
        }
        long mod = (long)(1e9 + 7);
        if (oneCount % 3 != 0) return 0;
        if (oneCount == 0) {
        	return (int)((1l * (n - 1) * (n - 2) / 2) % mod);
        }
        int gap1 = 0, gap2 = 0, tempCount = 0, lastOneIdx = -1;
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == '0') continue;
        	tempCount++;
        	if (tempCount == oneCount / 3) {
        		lastOneIdx = i;
        	} else if (lastOneIdx != -1) {
        		gap1 = i - lastOneIdx - 1;
        		break;
        	}
        }
        tempCount = 0; 
        lastOneIdx = -1;
        for (int i = n - 1; i > -1; i--) {
        	if (s.charAt(i) == '0') continue;
        	tempCount++;
        	if (tempCount == oneCount / 3) {
        		lastOneIdx = i;
        	} else if (lastOneIdx != -1) {
        		gap2 = lastOneIdx - i - 1;
        		break;
        	}
        }
        
        return (int)((1l * (gap1 + 1) * (gap2 + 1)) % mod);
    }
	
	public static void main(String[] args) {
		Problem1573 problem = new Problem1573();
		System.out.println(problem.numWays("10101"));
	}
}
