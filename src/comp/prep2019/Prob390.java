package comp.prep2019;

public class Prob390 {
	/**
	 * The first round, all the odd numbers removed.
The 2nd round, Divide the remaining number by 2.
(situation 1)Suppose (n/2) % 2 == 1. Then all the odd number of i/2 got removed.
(situation 1)The 3rd round, all the remaining number can be divided by 4. Recursion.
(situation 2) Suppose (n/2) % 2 == 0. Then all the even number of i/2 got removed. The remaining (i/2) are odd.
(situation 2) The 3rd round, first add 2 to the remaining odd i/2. Then we can do recursion.
	 */
	public int lastRemaining(int n) {
        if (n == 1) return n;
        if (n < 4) return 2;
        if ((n / 2) % 2 == 1) {
        	return 4 * lastRemaining((n - 2) / 4);
        } else return 4 * lastRemaining(n / 4) - 2;
        	
    }
}
