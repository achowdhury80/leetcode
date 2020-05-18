package comp.prep2019;

public class Prob168 {
	/* O(log n)
	 * Trick is in everey loop decrement n by 1
	 */
	public String convertToTitle(int n) {
	    if(n < 1) return null;
	    StringBuilder result = new StringBuilder();
	    while(n > 0) {
	    	n--;
	    	int rem = n % 26;
	    	result.insert(0, (char) (rem + 'A'));
	    	n /= 26;
	    }
	    return result.toString();
	  }
}