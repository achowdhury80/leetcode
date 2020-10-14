package comp.prep2019.less2000;

public class Prob1414 {
	/**
	 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
	 * @param k
	 * @return
	 */
	public int findMinFibonacciNumbers(int k) {
		if (k < 2) return k;
        int a = 1, b = 1, c = 2;
        while(b <= k) {
        	a = b;
        	b = c;
        	c = a + b;
        }
        return 1 + findMinFibonacciNumbers(k - a);
    }
}
