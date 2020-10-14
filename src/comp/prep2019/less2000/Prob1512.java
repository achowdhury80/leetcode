package comp.prep2019.less2000;

public class Prob1512 {
	public int numIdenticalPairs(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) {
        	arr[num]++;
        }
        int result = 0;
        for (int freq : arr) {
        	if (freq > 1) {
        		result += (freq * (freq - 1)) / 2;
        	}
        }
        return result;
    }
}	
