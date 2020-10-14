package comp.prep2019.less2000;
public class Prob1220 {
	public int countVowelPermutation(int n) {
        int mod = (int)(1e9 + 7);
        char[][] arr = new char[][] {{'e', 'i', 'u'}, {'a', 'i'}, {'e', 'o'}, {'i'}, {'i', 'o'}};
        String vowels = "aeiou";
        int[] dp = new int[] {1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
        	int[] temp = new int[5];
        	for (int j = 0; j < 5; j++) {
        		int sum = 0;
        		char[] prev = arr[j];
        		for (char c : prev) {
        			int idx = vowels.indexOf(c);
        			sum = (sum + dp[idx]) % mod;
        		}
        		temp[j] = sum;
        	}
        	dp = temp;
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) result = (result + dp[i]) % mod;
        return result;
    }
}
