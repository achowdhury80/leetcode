package comp.prep2019;

public class Prob713 {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, prod = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
        	prod *= nums[i];
        	while(prod >= k && start <= i) {
        		prod /= nums[start++];
        	}
        	if (start <= i) result += (i - start + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob713 prob = new Prob713();
		System.out.println(prob.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
	}
}
