package com.prep2020.medium;

public class Problem1904 {
	/**
	 * O(1)
	 * @param startTime
	 * @param finishTime
	 * @return
	 */
	public int numberOfRounds(String startTime, String finishTime) {
        int startTimeInMin = findInMintues(startTime),
        		endTimeInMin = findInMintues(finishTime);
        if (endTimeInMin < startTimeInMin) endTimeInMin += 1440;
        if (endTimeInMin - startTimeInMin < 15) return 0;
        return endTimeInMin / 15 - (startTimeInMin + 14) / 15;
    }
	
	private int findInMintues(String time) {
		String[] arr = time.split(":");
		return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
	}
	
	public static void main(String[] args) {
		Problem1904 problem = new Problem1904();
		//System.out.println(problem.numberOfRounds("00:00", "23:59"));
		System.out.println(problem.numberOfRounds("12:01", "12:44"));
	}
}
