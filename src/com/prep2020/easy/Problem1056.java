package com.prep2020.easy;

public class Problem1056 {
	public boolean confusingNumber(int N) {
        int result = 0;
        int cur = N;
        while(cur > 0) {
        	int last = cur % 10;
        	cur = cur / 10;
        	if (last == 0 || last == 1 || last == 8) result = result * 10 + last;
        	else if (last == 6) result = result * 10 + 9;
        	else if (last == 9) result = result * 10 + 6;
        	else return false;
        }
        return result != N;
    }
}
