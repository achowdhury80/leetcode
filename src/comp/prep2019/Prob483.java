package comp.prep2019;

public class Prob483 {
	/**
	 * https://leetcode.com/problems/smallest-good-base/discuss/625034/Easy-to-understand-java-solution-without-using-big-integer-class
	 * @param n
	 * @return
	 */
	public String smallestGoodBase(String n) {
		long val = Long.parseLong(n);
		long result = val - 1;
        for (int i = 64; i > 1; i--) {
        	long low = 2, high = val - 1;
        	while (low <= high) {
        		long mid = low + (high - low) / 2;
        		int retVal = isPossible(val, mid, i);
        		if (retVal == 0) return "" + mid;
        		if (retVal == 1) high = mid - 1;
        		else low = mid + 1;
        	}
        	
        }
        return "" + result;
    }

	private int isPossible(long val, long base, int digits) {
		if (base >= val) return 1;
		long mul = 1;
		for (int i = 0; i < digits && val > 0; i++) {
			val -= mul;
	        if( i != digits-1){
	            if(mul > val / base)
	                    return 1;
	        }
	        mul *= base;
		}
		if (val == 0) return 0;
		if (val > 0) return -1;
		return 1;
	}
}

