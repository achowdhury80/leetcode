package com.leet.algo;

public class Prob900 {
	private int[] data;
	private int cur = 0;
	public Prob900(int[] A) {
        data = A;
    }
    
    public int next(int n) {
        if (cur >= data.length) return -1;
        while(cur < data.length && n > 0) {
        	if (n > data[cur]) {
        		n -= data[cur];
        		cur += 2;
        	} else {
        		int result = data[cur + 1];
        		if (n == data[cur]) cur += 2;
        		else data[cur] -= n;
        		return result;
        	} 
        }
        return -1;
    }
}
