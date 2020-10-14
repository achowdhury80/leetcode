package comp.prep2019.less1000;

import java.util.Arrays;

public class Prob698 {
	public boolean canPartitionKSubsets(int[] nums, int k) {
	    int n;
	    if(k < 2) return true;
	    if(nums == null || (n = nums.length) == 0) return false;
	    int sum = 0;
	    for(int i : nums) sum += i;
	    if(sum % k != 0 || sum < k) return false;
	    sum /= k;
	    Arrays.sort(nums);
	    return isPossible(nums, sum, new int[k], nums.length - 1);
	  }

	  private boolean isPossible(int[] nums, int sum, int[] subsetSum, int lastIndex){
	    if(lastIndex == -1){
	      for (int s : subsetSum) if (s != sum) return false;
	      return true;
	    }
	    int num = nums[lastIndex];
	    for(int i = 0; i < subsetSum.length; i++){
	      if(sum - subsetSum[i] >= num){
	        subsetSum[i] += num;
	        if(isPossible(nums, sum, subsetSum, lastIndex - 1)) return true;
	        subsetSum[i] = subsetSum[i] - num;
	      }
	    }
	    return false;
	  }
}
