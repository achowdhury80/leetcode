package comp.prep2019;

public class Prob33 {
	public int search(int[] nums, int target) {
        if (nums.length < 1) return -1;
        int l = 0, h = nums.length - 1;
        while(l <= h) {
        	int mid = l + (h - l) / 2;
        	if (nums[mid] == target) return mid;
        	if (nums[mid] > nums[h]) {
        		if (target < nums[mid] && target > nums[h]) h = mid - 1;
        		else l = mid + 1;
        	} else {
        		if (target > nums[mid] && target <= nums[h]) l = mid + 1;
        		else h = mid - 1;
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Prob33 prob = new Prob33();
		System.out.println(prob.search(new int[] {4,5,6,7,0,1,2}, 0));
		System.out.println(prob.search(new int[] {1, 3}, 3));
	}
}
