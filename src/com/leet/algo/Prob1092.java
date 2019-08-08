package com.leet.algo;

public class Prob1092 {
	/**
	 * The first loop finds the number of overlapping characters in the shortest common supersequence at mem[n1][n2]
	 * To get the final string, start from the end and come back untill all characters are parsed.

While coming back, see if top or left value is equal to mem[i][j]
a. If equal to top, then add the character at i-1 of str1, and do i--
b. If equal to left, then add the character at j-1 of str2, and do j--
c. If none are equal, then add either of the characters, as they will be the same anyway and do i-- as well as j--
Then, if either i=0, or j=0, then add the remaining characters to the string of the other
Since, this is bottom-up, the answer is the reverse of the resulting string
	 * @param str1
	 * @param str2
	 * @return
	 */
	public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
        	char ch1 = str1.charAt(i - 1);
        	for (int j = 1; j <= n2; j++) {
        		char ch2 = str2.charAt(j - 1);
        		if (ch1 == ch2) dp[i][j] = 1 + dp[i - 1][j - 1];
        		else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        	}
        }
        StringBuilder sb = new StringBuilder();
        int i = n1, j = n2;
        while(i > 0 && j > 0) {
        	if (dp[i][j] == dp[i - 1][j]) {
        		sb.append(str1.charAt(i - 1));
        		i--;
        	} else if (dp[i][j] == dp[i][j - 1]) {
        		sb.append(str2.charAt(j - 1));
        		j--;
        	} else {
        		sb.append(str1.charAt(i - 1));
        		i--;
        		j--;
        	}
        }
        while(i > 0) {
        	sb.append(str1.charAt(i - 1));
        	i--;
        }
        while(j > 0) {
        	sb.append(str2.charAt(j - 1));
        	j--;
        }
        return sb.reverse().toString();
    }
}
