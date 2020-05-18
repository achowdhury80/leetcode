package comp.prep2019;

public class Prob91 {
	public int numDecodings(String s) {
		if (s.length() == 0) return 0;
        int[] dp = new int[2];
        char prev = s.charAt(0);
        if (prev == '0') return 0;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	int cur = 0;
        	if (prev == '1' || prev == '2' && c < '7') {
        		cur = dp[0] == 0 ? 1 : dp[0];
        	} 
        	if (c != '0') cur += (dp[1] == 0 ? 1 : dp[1]);
        	if (cur == 0) return 0;
        	dp[0] = dp[1];
        	dp[1] = cur;
        	prev = c;
        }
        return dp[1];
    }
	
	public static void main(String[] args) {
		Prob91 prob = new Prob91();
		System.out.println(prob.numDecodings("12"));
	}
}
