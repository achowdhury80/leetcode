package comp.prep2019;

public class Prob1092 {
	public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        String[][] dp = new String[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
        	for (int j = 0; j < dp[0].length; j++) dp[i][j] = "";
        }
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (str1.charAt(i) == str2.charAt(j)) {
        			dp[i + 1][j + 1] = dp[i][j] + str1.charAt(i);
        		} else {
        			String s1 = dp[i + 1][j], s2 = dp[i][j + 1];
        			if (s1.length() > s2.length()) dp[i + 1][j + 1] = dp[i + 1][j];
        			else dp[i + 1][j + 1] = dp[i][j + 1];
        		}
        	}
        }
        String result = "";
        int i = 0, j = 0;
        for (char c : dp[m][n].toCharArray()) {
        	while(str1.charAt(i) != c) result += str1.charAt(i++);
        	while(str2.charAt(j) != c) result += str2.charAt(j++);
        	result += c;
        	i++;
        	j++;
        }
        result += str1.substring(i);
        result += str2.substring(j);
        return result;
    }
}
