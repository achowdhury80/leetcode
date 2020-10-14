package comp.prep2019.less2000;

public class Prob1438 {
	public int longestSubarray(int[] nums, int limit) {
        int start = 0, min = 0, max = 0;
        int result = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
        	boolean flag = false;
        	if (Math.abs(nums[i] - nums[min]) > limit && Math.abs(nums[i] - nums[max]) > limit) {
        		start = Math.max(min, max) + 1;
        		flag = true;
        	} else if (Math.abs(nums[i] - nums[min]) > limit) {
        		start = min + 1;
        		flag = true;
        	} else if (Math.abs(nums[i] - nums[max]) > limit) {
        		start = max + 1;
        		flag = true;
        	} else {
        		if (nums[i] < nums[min]) min = i;
        		if (nums[i] > nums[max]) max = i;
        		length++;
        	}
        	if (flag) {
        		min = i; 
        		max = i;
        		length = 1;
        		for (int j = i - 1; j >= start && Math.abs(nums[i] - nums[j]) <= limit; j--) {
        			length++;
        			if (nums[j] < nums[min]) min = j;
            		if (nums[j] > nums[max]) max = j;
        		}
        	}
        	else result = Math.max(result, length);
        }
        return result;
    }
}
