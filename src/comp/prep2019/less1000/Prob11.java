package comp.prep2019.less1000;

public class Prob11 {
	/**
	 * O(N)
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
       int low = 0, high = height.length - 1;
       int result = 0;
       while(low < high) {
    	   result = Math.max(result, 
    			   (high - low) * Math.min(height[high], height[low]));
    	   if (height[low] >= height[high]) high--;
    	   else low++;
       }
       return result;
    }
}
