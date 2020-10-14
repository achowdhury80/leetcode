package comp.prep2019;

public class Prob125 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
        int l = 0, h = s.length() - 1;
        char[] arr = s.toCharArray();
        while(l < h) {
        	if (!Character.isLetter(arr[l]) && !Character.isDigit(arr[l])) {
        		l++;
        		continue;
        	}
        	if (!Character.isLetter(arr[h]) && !Character.isDigit(arr[h])) {
        		h--;
        		continue;
        	}
        	if (Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[h])) 
        		return false;
        	else {
        		l++;
        		h--;
        	}
        }
        return true;
    }
}
