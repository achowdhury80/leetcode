package comp.prep2019;

public class Prob774 {
	/**
	 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/solution/
	 * @param stations
	 * @param K
	 * @return
	 */
	public double minmaxGasDist(int[] stations, int K) {
        double low = 0, high = 1e8;
        while(high - low > 1e-6) {
        	double mid = low + (high -low) / 2;
        	if (possible(mid, stations, K)) high = mid;
        	else low = mid;
        }
        return low;
    }
	
	private boolean possible(double mid, int[] stations, int k) {
		int used = 0;
		for (int i = 0; i < stations.length - 1; i++) {
			used += (int)((stations[i + 1] - stations[i]) / mid);
		}
		return used <= k;
	}
	
	
}
