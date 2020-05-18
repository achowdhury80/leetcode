package comp.prep2019;

public class Prob34 {
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) return new int[] {-1, -1};
        int minIndex = minIndex(nums, target);
        if (minIndex == -1) return new int[] {-1, -1};
        int maxIndex = maxIndex(nums, target, minIndex);
        return new int[] {minIndex, maxIndex};
    }
	
	private int minIndex(int[] nums, int target) {
		int l = 0, h = nums.length - 1;
		while(l < h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] == target) h = mid;
			else if (nums[mid] > target) h = mid - 1;
			else l = mid + 1;
		}
		if (nums[l] == target) return l;
		return -1;
	}
	
	private int maxIndex(int[] nums, int target, int minIndex) {
		int l = minIndex, h = nums.length - 1;
		while(l + 1 < h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] == target) l = mid;
			else if (nums[mid] > target) h = mid - 1;
			else l = mid + 1;
		}
		return l + 1 < nums.length && nums[l + 1] == target ? l + 1 : l;
	}
	
	public static void main(String[] args) {
		Prob34 prob = new Prob34();
		System.out.println(prob.searchRange(new int[] {5,7,7,8,8,10}, 8));
	}
}
