package comp.prep2019.less1000;
public class Prob395 {
	public int longestSubstring(String s, int k) {
		if(s == null || s.length() < 0) return 0;
	    if(k < 2) return s.length();
	    if(k > s.length()) return 0;
	    return helper(s.toCharArray(), 0, s.length() - 1, k);
	}
	
	private int helper(char[] arr, int start, int end, int k) {
		if (end - start + 1 < k) return 0;
		int[] charMap = new int[26];
		for (int i = start; i <= end; i++) charMap[(arr[i] - 'a')]++;
		int result = 0;
		for (int i = 0; i < 26; i++) {
			if (charMap[i] != 0 && charMap[i] < k) {
				int begin = start;
				for (int j = start; j <= end; j++) {
					if ((arr[j] - 'a') == i) {
						result = Math.max(result, helper(arr, begin, j - 1, k));
						begin = j + 1;
					}
				}
				result = Math.max(result, helper(arr, begin, end, k));
				return result;
			}
		}
		return end - start + 1;
	}
	
	public static void main(String[] args) {
		Prob395 prob = new Prob395();
		System.out.println(prob.longestSubstring("aaabb", 3));
	}
}
