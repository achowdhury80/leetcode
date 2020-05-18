package comp.prep2019;

import java.util.HashSet;
import java.util.Set;

public class Prob217 {
	public boolean containsDuplicate1(int[] nums) {
	    if(nums == null || nums.length == 0) return false;
	    Set<Integer> set = new HashSet<>();
	    for(int i = 0; i < nums.length; i++){
	      if(set.contains(nums[i])) return true;
	      set.add(nums[i]);
	    }
	    return false;
	  }
}
