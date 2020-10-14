package comp.prep2019;

public class Prob233 {
	/**
	 * https://leetcode.com/problems/number-of-digit-one/solution/
	 * @param n
	 * @return
	 */
	public int countDigitOne(int n) {
		long result = 0;
        for (long i = 1l; i <= n; i *= 10) {
        	result += (n / (i * 10)) * i + Math.min(Math.max((n % (i * 10)) - i + 1, 
        			0), i);
        }
        return (int)result;
    }
}
