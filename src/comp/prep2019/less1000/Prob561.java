package comp.prep2019.less1000;

public class Prob561 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @return
	 */
	public int arrayPairSum(int[] nums) {
		int[] arr = new int[20001];
		for (int i : nums) arr[i + 10000]++;
        int i = 0, sum = 0;
        int n = nums.length;
        while(n > 0) {
        	while(arr[i] == 0) i++;
        	sum += i - 10000;
        	arr[i]--;
        	while(arr[i] == 0) i++;
        	arr[i]--;
        	n -= 2;
        }
        return sum;
    }
}
