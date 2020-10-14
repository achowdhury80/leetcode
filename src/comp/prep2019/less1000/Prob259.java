package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob259 {
	public int threeSumSmaller(int[] nums, int target) {
		int n = nums.length;
        if (n < 3) return 0;
        int result = 0;
        Arrays.sort(nums);
        for (int i = n - 1; i > 1; i--) {
        	int l = 0, r = i - 1;
        	while(l < r) {
        		if (nums[l] + nums[r] + nums[i] >= target) {
        			r--;
        		} else {
        			result += r - l;
        			l++;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob259 prob = new Prob259();
		System.out.println(prob.threeSumSmaller(new int[] {-1,  1, -1, -1}, -1));
	}
}
