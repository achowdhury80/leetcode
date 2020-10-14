package comp.prep2019.less2000;
import java.util.*;
public class Prob1191 {
	public int kConcatenationMaxSum(int[] arr, int k) {
		int mod = (int)(1e9 + 7);
        long sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        long maxSubArrSum = 0;
        if (sum > 0) {
        	maxSubArrSum = findMaxSubArraySum(createListFromArray(arr, 1));
        	if (sum == maxSubArrSum) return (int)((sum * k) % mod);
        	else return (int)((sum * (k - 1) + maxSubArrSum) % mod);
        } 
        return (int)(findMaxSubArraySum(createListFromArray(arr, 2)) % mod);
    }
	
	private long findMaxSubArraySum(List<Integer> list) {
		long sum = 0, result = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			result = Math.max(result, sum);
			if (sum < 0) sum = 0;
		}
		return result;
	}
	
	private List<Integer> createListFromArray(int[] arr, int repeat) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < repeat; i++) {
			for (int j = 0; j < arr.length; j++) {
				result.add(arr[j]);
			}
		}
		return result;
	}
}
