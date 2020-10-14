package comp.prep2019.less2000;

public class Prob1343 {
	public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        int result = 0;
        if ((sum + 0.0) / k >= threshold) result++;
        for (int i = k; i < arr.length; i++) {
        	sum = sum - arr[i - k] + arr[i];
        	if ((sum + 0.0) / k >= threshold) result++;
        }
        return result;
    }
}
