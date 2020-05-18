package comp.prep2019;

public class Prob1250 {
	// find gcd
	public boolean isGoodArray(int[] nums) {
        if (nums.length < 1) return false;
        int a = nums[0];
        if (a == 1) return true;
        for (int i = 1; i < nums.length; i++) {
        	a = findGcd(a, nums[i]);
        	if (a == 1) return true;
        }
        return false;
    }
	
	private int findGcd(int x, int y) {
		if (y > x) return findGcd(y, x);
		if (y == 0) return x;
		return findGcd(y, x % y);
	}
}
