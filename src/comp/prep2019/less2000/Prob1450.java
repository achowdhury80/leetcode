package comp.prep2019.less2000;

public class Prob1450 {
	/**
	 * o(n) time
	 * @param startTime
	 * @param endTime
	 * @param queryTime
	 * @return
	 */
	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int result = 0;
        for (int i = 0; i < startTime.length; i++) {
        	if (startTime[i] <= queryTime && endTime[i] >= queryTime) result++;
        }
        return result;
    }
}
