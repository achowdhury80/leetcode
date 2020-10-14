package comp.prep2019;

public class Prob91 {
	public int numDecodings(String s) {
		if (s.length() == 0) return 0;
        int[] dp = new int[2];
        char c;
        if ((c = s.charAt(0)) == '0') return 0;
        if (s.length() < 2) return 1;
        dp[0] = 1;
        char ch = s.charAt(1);
        if (ch != '0') dp[1] = 1;
        if (c == '1' || (c == '2' && ch < '7')) dp[1]++;
        c = ch;
        for (int i = 2; i < s.length(); i++) {
        	ch = s.charAt(i);
        	int cur = ch == '0' ? 0 : dp[1];
        	if (c == '1' || (c == '2' && ch < '7')) cur += dp[0];
        	if (cur == 0) return 0;
        	dp[0] = dp[1];
        	dp[1] = cur;
        	c = ch;
        }
        return dp[1];
    }
	
	public static void main(String[] args) {
		Prob91 prob = new Prob91();
		//System.out.println(prob.numDecodings("12"));
		System.out.println(prob.numDecodings("1010"));
	}
}
