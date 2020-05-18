package comp.prep2019;

public class Prob260 {
	/**
	 * find xor of all numbers, say result
	 * lets say ith bit of result is 1
	 * make two groups
	 * for each num,
	 * if ith bit of num is 0 then xor it to group 1
	 * else xor it to group 2
	 * return result of group 1 and 2
	 * @param nums
	 * @return
	 */
	public int[] singleNumber(int[] nums) {
        int xor = nums[0] ^ nums[1];
        for (int i = 2; i < nums.length; i++) {
        	xor ^= nums[i];
        }
        int i = 0;
        while(i < 31) {
        	if((xor & 1) > 0) {
        		break;
        	}
        	xor >>= 1;
        	i++;
        }
        int[] result = new int[] {0, 0};
        for (int num : nums) {
        	if (((num >> i) & 1) == 0) result[0] ^= num;
        	else result[1] ^= num;
        }
        return result;
    }
}
