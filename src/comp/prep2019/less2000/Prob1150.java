package comp.prep2019.less2000;

public class Prob1150 {
	public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        int mid = len / 2;
        if (nums[mid] != target) return false;
        if (len == 1) return true;
        int start = 0, end = mid;
        while(start < end) {
        	int m = start + (end - start) / 2;
        	if (nums[m] == target) end = m;
        	else start = m + 1;
        }
        int low = start;
        start = mid; 
        end = len - 1;
        while(start < end) {
        	int m = start + (end - start) / 2;
        	if (nums[m] == target) {
        		start = m;
        		if (nums[start + 1] == target) start++;
        		else break;
        	}
        	else end = m - 1;
        }
        return (start - low + 1) >= len / 2 + 1;
        
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,4,5,5,5,5,5,6,6};
		System.out.println(new Prob1150().isMajorityElement(nums, 5));
	}
}
