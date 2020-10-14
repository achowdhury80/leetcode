package comp.prep2019.less1000;

public class Prob387 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) arr[i] = -1;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	int idx = c - 'a';
        	if (arr[idx] > -1) arr[idx] = Integer.MAX_VALUE;
        	else arr[idx] = i;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++)
        	if (arr[i] != -1) result = Math.min(result, arr[i]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
