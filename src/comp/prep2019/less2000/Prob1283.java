package comp.prep2019.less2000;

public class Prob1283 {
	public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	max = Math.max(max, nums[i]);
        }
        if (threshold <= nums.length) return max;
        int l = 1, r = max;
        while (l < r) {
        	int mid = l + (r - l) / 2;
        	if (findDiv(nums, mid) <= threshold) r = mid;
        	else l = mid + 1;
        }
        return l;
    }
	
	private int findDiv(int[] nums, int div) {
		int result = 0;
		for (int i : nums) result += (i + div - 1) / div;
		return result;
	}
	
	public static void main(String[] args) {
		Prob1283 prob = new Prob1283();
		System.out.println(prob.smallestDivisor(new int[] {1,2,5,9}, 6));
	}
}
