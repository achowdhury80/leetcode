package comp.prep2019.less1000;

public class Prob680 {
	/**
	 * O(N) time and O(1) space
	 * start for checking palindromme from both end
	 * if unMatch found, then check deleting one of the end char makes it palindromme
	 * @param s
	 * @return
	 */
	public boolean validPalindrome(String s) {
        if (s.length() < 3) return true;
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
        	if (arr[i] != arr[n - 1 - i]) {
        		return isPalindromme(arr, i, n - i - 2) 
        				|| isPalindromme(arr, i + 1, n - i - 1);
        	}
        }
        return true;
    }
	
	private boolean isPalindromme(char[] arr, int start, int end) {
		while(start < end) {
			if(arr[start++] != arr[end--]) return false;
		}
		return true;
	}
}
 