package comp.prep2019.less1000;

public class Prob5 {
	/**
	 * O(N^2) time and space
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		int n = s.length();
		if (n < 2) return s;
		char[] arr = s.toCharArray();
		//dp[i][j] is whether substring starting at index i and ending at index j is palindromme
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        String result = "" + s.charAt(0);
        //i is the length of substring
        for (int j = 0; j < n; j++) {
        	// j is the start index
        	for (int i = j - 1; i > -1; i--) {
        		if (arr[i] == arr[j] && (i + 1 == j || dp[i + 1][j - 1])) {
        			dp[i][j] = true;
        			if (result.length() < j - i + 1) result = s.substring(i, j + 1);
        		}
        	}
        }
        return result;
    }
}
