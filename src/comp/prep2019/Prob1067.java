package comp.prep2019;

public class Prob1067 {
	/**
	 * https://leetcode.com/problems/digit-count-in-range/discuss/303462/Simple-iterative-Java-solution-extending-number-of-digits-one
	 * @param d
	 * @param low
	 * @param high
	 * @return
	 */
	public int digitsCount(int d, int low, int high) {
        if (low == 1) countDigit(high, d);
        return countDigit(high, d) - countDigit(low - 1, d);
    }
	
	public int countDigit(int n, int d) {
		long result = 0;
        for (long i = 1l; i <= n; i *= 10) {
        	result += (n / (i * 10)) * i;
        	if (d > 0) result += Math.min(Math.max((n % (i * 10)) - i * d 
        			+ 1, 0), i);
        	else {
        		if(n / (i * 10) > 0) {
                    if(i > 1) {  // comment2: when d == 0, we need avoid to take numbers like 0xxxx into account.
                        result -= i;
                        result += Math.min(n % (i * 10) + 1, i);  
                    }
                }
        	}
        }
        return (int)result;
    }
}
