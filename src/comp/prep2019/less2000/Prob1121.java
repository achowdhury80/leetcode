package comp.prep2019.less2000;

public class Prob1121 {
	private int findFirstBigger(int[] nums, int i, int lo, int hi) {
        while (lo < hi) {
            int m = (lo+hi) >> 1;
            if (nums[m] > nums[i]) {
                hi = m;
            } else {
                lo = m+1;
            }
        }
        return lo;
    }
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int M = nums.length / K; // maximum valid quantity of same numbers
        int i = 0;
        while (i+M < nums.length) {
            if (nums[i] == nums[i+M]) return false; // overflow the maximum valid quantity M
            i = findFirstBigger(nums, i, i+1, i+M); // i is the first index of same number
        }
        return true;
    }
    
    public static void main(String[] args) {
    	Prob1121 prob = new Prob1121();
    	System.out.println(prob.canDivideIntoSubsequences(new int[] {1, 2, 3, 3}, 2));
    }
}
