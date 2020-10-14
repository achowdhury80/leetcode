package comp.prep2019.less2000;

public class Prob1482 {
	public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
        	min = Math.min(min, day);
        	max = Math.max(max, day);
        }
        int low = min, high = max;
        int result = Integer.MAX_VALUE;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	if (canMake(bloomDay, m, k, mid)) {
        		result = mid;
        		high = mid - 1;
        	} else low = mid + 1;
        }
        return result;
        
    }
	
	private boolean canMake(int[] bloomDay, int m, int k, int days) {
		int start = -1;
		for (int i = 0; i < bloomDay.length && m > 0; i++) {
			if (bloomDay[i] > days) {
				if (start != -1) {
					m -= (i - start) / k;
					start = -1;
				}
			} else {
				if (start == -1) start = i;
			}
		}
		if (start != -1) m -= (bloomDay.length - start) / k;
		return m < 1;
	}
}
