package com.prep2020.medium;

public class Problem1870 {
	/**
	 * O(nlogn)
	 * @param dist
	 * @param hour
	 * @return
	 */
	public int minSpeedOnTime(int[] dist, double hour) {
        int result = -1;
        int low = 1, high = 10000000;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	if (possible(dist, hour, mid)) {
        		result = mid;
        		high = mid - 1;
        	} else low = mid + 1;
        }
        return result;
    }

	private boolean possible(int[] dist, double hour, int sp) {
		double time = 0;
		for (int i = 0; i < dist.length - 1; i++) {
			time += dist[i] / sp;
			if (dist[i] % sp != 0) time++;
			if (time > hour) return false;
		}
		return hour >= time + (0. + dist[dist.length - 1]) / sp;
	}
	
	public static void main(String[] args) {
		Problem1870 problem = new Problem1870();
		System.out.println(problem.minSpeedOnTime(new int[] {1, 1, 100000}, 2.01));
	}
}
