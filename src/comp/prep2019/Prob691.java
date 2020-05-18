package comp.prep2019;

public class Prob691 {
	public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[] dp = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) dp[i] = -1;
        for (int state = 0; state < (1 << n); state++) {
        	if (dp[state] == -1) continue;
        	for (String s : stickers) {
        		int now = state;
        		for (char c : s.toCharArray()) {
        			for (int i = 0; i < n; i++) {
        				if (((now >> i) & 1) == 1) continue;
        				if (target.charAt(i) == c) {
        					now |= (1 << i);
        					break;
        				}
        			}
        		}
        		if (dp[now] == -1 || dp[now] > dp[state] + 1) {
        			dp[now] = dp[state] + 1;
        		}
        	}
        }
        return dp[(1 << n) - 1];
    }
}
