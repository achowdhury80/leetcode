package com.prep2020.easy;

public class Problem2214 {
	public int convertTime(String current, String correct) {
        return findNumberOfSteps(findDiff(current, correct));
    }
	
	private int findNumberOfSteps(int val) {
		int result = 0;
		result += (val / 60);
		val %= 60;
		result += (val / 15);
		val %= 15;
		result += (val / 5);
		val %= 5;
		result += val;
		return result;
	}
	
	private int findDiff(String current, String correct) {
		int t1 = findTimeInMin(current), t2 = findTimeInMin(correct);
		if (t2 < t1) t2 += 1440;
		return t2 - t1;
	}

	private int findTimeInMin(String time) {
		String[] arr = time.split(":");
		if (arr[0].charAt(0) == '0') arr[0] = arr[0].substring(1);
		if (arr[1].charAt(0) == '0') arr[1] = arr[1].substring(1);
		return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
	}
}
