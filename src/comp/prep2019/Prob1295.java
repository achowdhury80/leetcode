package comp.prep2019;

public class Prob1295 {
	/**
	 * O(N)
	 * since nums[i] <= 10^5
	 * starting from 10^5 we can go till 10^0 with reduction by 10 
	 * when i = 10 ^ 5, it is even, next odd, so on.. 
	 * @param nums
	 * @return
	 */
	public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
        	boolean odd = false;
        	for (int i = 100000; i > 0; i /= 10) {
        		if (num >= i) {
        			if (!odd) result++;
        			break;
        		}
        		odd ^= true;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1295 prob = new Prob1295();
		System.out.println(prob.findNumbers(new int[] {12,345,2,6,7896}));
	}
}
