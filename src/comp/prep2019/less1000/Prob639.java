package comp.prep2019.less1000;

public class Prob639 {
	public int numDecodings(String s) {
		if (s.charAt(0) == '0') return 0;
        int[] dp = new int[2];
        int mod = (int)(1e9 + 7);
        dp[0] = 1;
        dp[1] = combinationSingle(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
        	char prev = s.charAt(i - 1);
        	char cur = s.charAt(i);
        	int temp = ((dp[0] * combination(prev, cur)) % mod 
        			+ (dp[1] * combinationSingle(cur)) % mod) % mod;
        	dp[0] = dp[1];
        	dp[1] = temp;
        }
        return dp[1];
    }
	
	private int combination(char prev, char cur) {
		if (prev == '*') {
			if (cur == '*') return 16;
			return 1 + (cur < '7' ? 1 : 0);
		} else {
			if (prev != '1' && prev != '2') return 0;
			if (prev == '1' && cur == '*') return 9;
			if (prev == '2' && cur == '*') return 6;
			if (cur != '*') {
				if (prev == '1') return 1;
				if (prev == '2' && cur < '7') return 1;
				return 0;		
			}
		}
		return 0;
	}
	
	private int combinationSingle(char c) {
		if (c == '0') return 0;
		if (c == '*') return 9;
		return 1;
	}
	
	public static void main(String[] args) {
		Prob639 prob = new Prob639();
		System.out.println(prob.numDecodings("2*"));
		System.out.println(prob.numDecodings("**"));
	}
}
