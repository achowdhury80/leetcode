package comp.prep2019;

public class Prob300 {
	/*
	 * check the other solution
	 */
	public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
        	dp[i] = 1;
        	for (int j = i - 1; j > -1; j--) {
        		if (nums[j] < nums[i]) {
        			dp[i] = Math.max(dp[i], 1 + dp[j]);
        		}
        	}
        	result = Math.max(result, dp[i]);
        }
        return result;
    }
	/*
	 * public int lengthOfLIS(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    if(nums.length == 1) return 1;
    int n = nums.length;
    int[] tailTable = new int[nums.length + 1];
    tailTable[0] = nums[0];
    int nextSlot = 1;
    for(int i = 1; i < nums.length; i++){
      if(nums[i] < tailTable[0]){
        tailTable[0] = nums[i];
      } else if(nums[i] > tailTable[nextSlot - 1]){
        tailTable[nextSlot++] = nums[i];
      } else {
        tailTable[findCeilIndex(tailTable, nums[i], 0, nextSlot - 1)] = nums[i];
      }
    }
    return nextSlot;

  }

  private int findCeilIndex(int[] tailTable, int nextNumber, int startingSlot, int endSlot){
    while(endSlot - startingSlot > 0){
      int mid = (startingSlot + endSlot) / 2;
      if(tailTable[mid] == nextNumber) return mid;
      if(tailTable[mid] > nextNumber){
        endSlot = mid;
      } else {
        startingSlot = mid + 1;
      }
    }
    return startingSlot;
  }
	 */
}
