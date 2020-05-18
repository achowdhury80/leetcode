package comp.prep2019;

public class Prob209 {
	public int minSubArrayLen(int s, int[] nums) {
		if(s == 0) return 0;
		int start = 0, sum = 0, result = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while(sum - nums[start] >= s) {
				sum -= nums[start++];
			}
			if (sum >= s) result = Math.min(result, i - start + 1);
			if(sum >= s) {
				sum -= nums[start++];
			}
		}
		return result == Integer.MAX_VALUE ? 0 : result;
    }
	
	public static void main(String[] args) {
		Prob209 prob = new Prob209();
		System.out.println(prob.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
	}
}
