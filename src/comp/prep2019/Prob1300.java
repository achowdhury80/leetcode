package comp.prep2019;

import java.util.Arrays;

public class Prob1300 {
	public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) sum[i] = arr[i] + sum[i - 1];
        if (sum[arr.length - 1] <= target) return arr[arr.length - 1];
        int low = 0, high = arr[arr.length - 2];
        int result = arr[arr.length - 1], diff = Math.abs(sum[sum.length - 1] - target);
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	int computed = computeSum(arr, sum, mid);
        	if (computed >= target) {
        		high = mid;
        	} else low = mid + 1;
        	int newDiff = Math.abs(target - computed);
        	if (diff > newDiff) {
        		result = mid;
        		diff = newDiff;
        	}
        	else if (diff == newDiff) result = Math.min(result, mid);
        }
        return result;
    }
	
	private int computeSum(int[] arr, int[] sum, int val) {
		int idx = Arrays.binarySearch(arr, val);
		int result = 0;
		if (idx > -1) {
			result = sum[idx] + (sum.length - 1 - idx) * val;
		} else {
			idx = -idx - 1;
			result = (idx == 0 ? 0 : sum[idx - 1]) + + (sum.length - idx) * val;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob1300 prob = new Prob1300();
		System.out.println(prob.findBestValue(new int[]{60864,25176,27249,21296,20204},56803));
	}
}
