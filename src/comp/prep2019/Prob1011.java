package comp.prep2019;

public class Prob1011 {
	public int shipWithinDays(int[] weights, int D) {
        int sum = 0, max = 0;
        for (int w : weights) {
        	sum += w;
        	max = Math.max(max, w);
        }
        int start = max, end = sum;
        while(start < end) {
        	int mid = start + (end - start) / 2 ;
        	if (timeSpent(weights, mid) <= D) {
        		end = mid;
        	} else start = mid + 1;
        }
        return start;
    }
	
	private int timeSpent(int[] weights, int cap) {
		int result = 0;
		int cur = 0;
		for (int i = 0; i < weights.length; i++) {
			if(cur + weights[i] > cap) {
				result++;
				cur = weights[i];
			} else cur += weights[i];
		}
		if (cur > 0) result++;
		return result;
	}
}
