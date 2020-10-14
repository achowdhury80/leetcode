package comp.prep2019;

public class Prob97 {
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.equals(s3) || s2.equals(s3)) return true;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s3.length(); i++) {
        	for (int j = 0; j <= Math.min(i, s1.length()); j++) {
        		int s2Index = i - j;
        		if (s2Index > s2.length()) continue;
        		if (j > 0 && dp[j - 1][s2Index] 
        				&& s1.charAt(j - 1) == s3.charAt(i - 1)) {
        			dp[j][s2Index] = true;
        		} else if (s2Index > 0 && dp[j][s2Index - 1] 
        				&& s2.charAt(s2Index - 1) == s3.charAt(i - 1)) {
        			dp[j][s2Index] = true;
        		}
        	}
        }
        return dp[s1.length()][s2.length()];
    }
	
	public static void main(String[] args) {
		Prob97 prob = new Prob97();
		//System.out.println(prob.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(prob.isInterleave("aa", "ab", "abaa"));
	}
}
