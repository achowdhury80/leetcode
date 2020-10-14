package comp.prep2019;

public class Prob1100 {
	/**
	 * O(N)
	 * @param S
	 * @param K
	 * @return
	 */
	public int numKLenSubstrNoRepeats(String S, int K) {
        int[] arr = new int[26];
        char[] chars = S.toCharArray();
        int count = 0;
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
        	char c = chars[i];
        	arr[c - 'a']++;
        	if (arr[c - 'a'] == 1) count++;
        	if (i - K > -1) {
        		arr[chars[i - K] - 'a']--;
        		if (arr[chars[i - K] - 'a'] == 0) count--;
        	}
        	if (count == K) result++;
        }
        return result;
    }
}
