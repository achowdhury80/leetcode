package comp.prep2019.less2000;

public class Prob1415 {
	public String getHappyString(int n, int k) {
		int dependantVariation = (int) Math.pow(2, n - 1);
		int totalVariation = (int) (3 * dependantVariation);
		if (totalVariation < k) return "";
		int idx = (k - 1) / dependantVariation;
		char c = (char)('a' + idx);
		return c + helper(n - 1, k - idx * dependantVariation, c);
    }

	private String helper(int n, int k, char preChar) {
		if (n == 0) return "";
		char nextChar = preChar == 'a' ? 'b' : 'a';
		if (n == 1) {
			if (k == 1) return "" + nextChar;
			else return preChar == 'c' ? "b" : "c"; 
		}
		int variation = (int) Math.pow(2, (n - 1));
		if (variation >= k) return nextChar + helper(n - 1, k, nextChar);
		nextChar = preChar == 'c' ? 'b' : 'c'; 
		return nextChar + helper(n - 1, k - (int) Math.pow(2, (n - 1)), nextChar);
	}
}
