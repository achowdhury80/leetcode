package comp.prep2019.less2000;

import java.util.Arrays;

public class Prob1048 {
	public int longestStrChain(String[] words) {
        Arrays.sort(words, (x, y)-> x.length() - y.length());
        int[] dp = new int[words.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < words.length; i++) {
        	dp[i] = 1;
        	for (int j = i - 1; j > -1 && words[i].length() - words[j].length() < 2; j--) {
        		if (words[i].length() == words[j].length()) continue;
        		if (isOneEditApart(words[i], words[j])) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
	
	private boolean isOneEditApart(String bigger, String smaller) {
		boolean flag = false;
		for (int i = 0, j = 0; i < bigger.length() && j < smaller.length(); i++, j++) {
			if (bigger.charAt(i) != smaller.charAt(j)) {
				if (flag) return false;
				j--;
				flag = true;
			}
		}
		return true;
	}
}
