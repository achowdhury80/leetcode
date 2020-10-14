package comp.prep2019.less1000;

public class Prob33 {
	/**
	 * O(logn)
	 * always on high side
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		if (nums.length < 1) return -1;
        int low = 0, high = nums.length - 1;
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	if (nums[mid] == target) return mid;
        	if (nums[mid] > nums[high]) {
        		if (target <= nums[high] || target > nums[mid]) low = mid + 1;
        		else high = mid - 1;
        	} else {
        		if (target > nums[mid] && target <= nums[high]) low = mid + 1;
        		else high = mid - 1;
        	}
        }
        return nums[low] == target ? low : -1;
    }
	
	public static void main(String[] args) {
		Prob33 prob = new Prob33();
		System.out.println(prob.search(new int[] {4,5,6,7,0,1,2}, 0));
		//System.out.println(prob.search(new int[] {1, 3}, 3));
	}
}
