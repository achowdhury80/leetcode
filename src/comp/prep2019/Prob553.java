package comp.prep2019;

public class Prob553 {
	public String optimalDivision(int[] nums) {

	    if(nums == null || nums.length == 0) return null;
	    if(nums.length == 1) return "" + nums[0];
	    if(nums.length == 2) return nums[0] + "/" + nums[1];
	    StringBuilder ans = new StringBuilder("" + nums[0] + "/(");
	    for(int i = 1; i < nums.length; i++){
	      ans.append(nums[i] + "/");
	    }
	    ans.delete(ans.length() - 1, ans.length());
	    ans.append(")");
	    return ans.toString();
	  }

}
