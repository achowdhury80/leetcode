package comp.prep2019;

public class Prob137 {
	/**
	 * starting from right most bit for each number
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		//array of 32 bit count
        int[] arr = new int[32];
        // for each bit
        for (int i = 0; i < 32; i++) {
        	for (int num : nums) {
        		// check ith bit is 1
        		if (((num >> i) & 1) == 1)
        			// raise ith bit count by 1. if it is 3, set to 0
        			arr[i] = (arr[i] + 1) % 3;
        	}
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
        	result ^= arr[i] << i;
        }
        return result;
    }
}
