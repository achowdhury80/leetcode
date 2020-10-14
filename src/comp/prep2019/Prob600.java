package comp.prep2019;

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
        int[] dp = new int[] {2, 3};
        int base = 4;
        while(base * 2 - 1 <= num) {
        	int temp = dp[1] + dp[0];
        	dp[0] = dp[1];
        	dp[1] = temp;
        	base <<= 1;
        }
        num -= base;
        num = Math.min(num, base / 2 - 1);
        return dp[1] + findIntegers(num);
    }
	
	public static void main(String[] args) {
		Prob600 prob = new Prob600();
		System.out.println(prob.findIntegers(4));
	}
}
