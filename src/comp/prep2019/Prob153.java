package comp.prep2019;

public class Prob153 {
	public int findMin(int[] nums) {
        if (nums.length < 2) return nums[0];
        int l = 0, r = nums.length - 1;
        int mid = -1;
        while(l < r) {
        	mid = l + (r - l) / 2;
        	if (nums[mid] > nums[r]) l = mid + 1;
        	else r = mid;
        }
        return nums[l];
    }
	
	public static void main(String[] args) {
		Prob153 prob = new Prob153();
		System.out.println(prob.findMin(new int[] {2, 1}));
	}
	
}
