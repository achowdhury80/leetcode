package comp.prep2019;
public class Prob467 {
	/**
	 * find max length of substring ending with each character
	 * answer is the sum of those maximum length
	 * @param p
	 * @return
	 */
	public int findSubstringInWraproundString(String p) {
		if (p == null || p.equals("")) return 0;
	    int n;
	    if ((n = p.length()) < 2) return 1;
	    int[] count = new int[26];
	    int maxLength = 0;
	    for (int i = 0; i < p.length(); i++) {
	    	char c = p.charAt(i);
	    	if (i > 0  && ((c - p.charAt(i - 1)) == 1 || (c - p.charAt(i - 1)) == -25)) {
	    		maxLength++;
	    	} else {
	    		maxLength = 1;
	    	}
	    	count[c - 'a'] = Math.max(count[c - 'a'], maxLength);
	    }
	    int result = 0;
	    for (int i : count) result += i;
	    return result;
    }
}
