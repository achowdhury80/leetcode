package comp.prep2019.less1000;

public class Prob334 {
	public boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length < 3) return false;
	    Integer[] two = new Integer[2];
	    two[0] = nums[0];  
	    for (int i = 1; i < nums.length; i++) {
	    	if (two[1] != null) {
	    		if (two[1] < nums[i]) return true;
	    		if (two[1] == nums[i]) continue;
	    		if (two[1] > nums[i] && nums[i] > two[0]) {
	    			two[1] = nums[i];
	    		} else {
	    			two[0] =  nums[i];
	    		}
	    	} else {
	    		if (two[0] > nums[i]) two[0] = nums[i];
	    		else if(two[0] == nums[i]) continue;
	    		else two[1] = nums[i];
	    	} 
	    } 
	    return false; 
    }
}
