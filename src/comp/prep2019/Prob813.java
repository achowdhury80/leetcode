package comp.prep2019;
import java.util.*;
public class Prob813 {
	public double largestSumOfAverages(int[] A, int K) {
        int[] sum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) sum[i + 1] = A[i] + sum[i];
        return helper(sum, 0, new HashMap<String, Double>(), K);
    }
	
	private double helper(int[] sum, int start, Map<String, Double> map, int k) {
		String key = start + ":" + k;
		if(map.containsKey(key)) return map.get(key);
		int numberOfelementsRemaining = sum.length - start - 1;
		if (k == 1) {
			double avg = (0.0 + sum[sum.length - 1] - sum[start]) / numberOfelementsRemaining;
			map.put(key, avg);
			return avg;
		}
		for (int i = start; k - 1 <= numberOfelementsRemaining - (i - start + 1); i++) {
			double thisAvg = (sum[i + 1] - sum[start] + 0.0) / (i - start + 1);
			double otherAvg = helper(sum, i + 1, map, k - 1);
			map.put(key, Math.max(map.getOrDefault(key, 0.0), thisAvg + otherAvg));
		}
		return map.get(key);
	}
	
	public static void main(String[] args) {
		Prob813 prob = new Prob813();
		System.out.println(prob.largestSumOfAverages(new int[] {9,1,2,3,9},3));
	}
}
