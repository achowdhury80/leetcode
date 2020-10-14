package comp.prep2019.less1000;

public class Prob849 {
	/**
	 * O(N) time and O(1) space
	 * maintain start and end
	 * @param seats
	 * @return
	 */
	public int maxDistToClosest(int[] seats) {
        int start = -1, end = -1;
        int result = 0;
        for (int i = 0; i < seats.length; i++) {
        	if (seats[i] == 1) {
        		if (end != -1) start = end;
        		end = i;
        		result = Math.max(result, start == -1 ? i : (end - start) / 2);
        	}
        }
        if (end != seats.length - 1) {
        	result = Math.max(result, seats.length - 1 - end);
        }
        return result;
    }
}
