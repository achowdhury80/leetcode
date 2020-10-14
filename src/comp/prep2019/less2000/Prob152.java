package comp.prep2019.less2000;

public class Prob152 {
	/**
	 * O(N) time
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        long prod = 1;
        long lastNegativeProd = 1;
        for (int num : nums) {
        	prod *= num;
        	result = Math.max(result, (int)prod);
        	if (num == 0) {
        		lastNegativeProd = 1;
        		prod = 1;
        	} else if (num < 0) {
        		if (lastNegativeProd > 0) {
        			lastNegativeProd = prod;
        			continue;
        		} 
        	}
        	if(prod < 0) {
        		result = Math.max(result, (int)(prod / lastNegativeProd));
        	}
        }
        return result;
    }
}
