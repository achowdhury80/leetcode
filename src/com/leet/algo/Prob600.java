package com.leet.algo;
import java.util.*;
public class Prob600 {
	public int findIntegers(int num) {
		// dp[k] means how many answers if n == 2^k - 1
        // we have dp[k] = dp[k - 1] + dp[k - 2], and dp[1] = 2, dp[2] = 3
        // Because, for binary numbers in range [0, 2^k - 1], the first half start with '0' and the 2nd half start with '1'.
        // when adding '1' at front to make the range [0, 2^(k+1) - 1], it contains three parts:
        // range [0, 2^k - 1], = dp[k - 1]
        // range [2^k, 2^k + 2^(k-1) - 1], dp[k - 2]
        // range [2^k + 2^(k-1), 2^(k+1) - 1], invalid as the first 2 digits are '1's
		if(num < 3) return num + 1;
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(2);
        int base = 2;
        int k = 1;
        while(base * 2 - 1 <= num) {
        	k++;
        	dp.add(dp.get(k - 1) + dp.get(k - 2));
        	base <<= 1;
        }
        num -= base;
        num = Math.min(num, base / 2 - 1);
        return dp.get(k) + findIntegers(num);
    }
}
