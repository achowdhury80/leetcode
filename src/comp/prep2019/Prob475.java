package comp.prep2019;

import java.util.Arrays;

public class Prob475 {
	/**
	 * o(NlogN) for sort
	 * for each house find the closest
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        int lastPos = 0; // last heater position
        for (int i = 0; i < houses.length; i++) {
        	while (heaters.length > lastPos + 1 
        			&& heaters[lastPos + 1] <= houses[i]) lastPos++;
        	int dis = Math.abs(houses[i] - heaters[lastPos]);
        	if (heaters[lastPos] < houses[i] && heaters.length > lastPos + 1) {
        		if (dis >= heaters[lastPos + 1] - houses[i]) {
        			dis = heaters[lastPos + 1] - houses[i];
        			lastPos++;
        		}
        	}
        	result = Math.max(result, dis);
        }
        return result;
    }
}
