package comp.prep2019.less1000;

public class Prob41 {
	public int firstMissingPositive(int[] nums) {
		int missing = 1;
        for (int num : nums) {
        	if (num == 1) {
        		missing = 0;
        		break;
        	}
        }
        if (missing == 1) return 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
        	if (nums[i] < 1 || nums[i] > n) {
        		nums[i] = 1;
        	}
        }
        for (int i = 0; i < n; i++) {
        	int elem = Math.abs(nums[i]);
        	int idx = elem == n ? 0 : elem;
        	if (nums[idx] > 0) nums[idx] *= -1; 
        }
        for (int i = 1; i < n; i++) if (nums[i] > 0) return i;
        if (nums[0] > 0) return n;
        return n + 1;
    }
	
	public static void main(String[] args) {
		Prob41 prob = new Prob41();
		System.out.println(prob.firstMissingPositive(new int[] {1, 2, 0}));
	}
}

