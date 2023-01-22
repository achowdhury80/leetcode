package com.prep2020.medium;



public class Problem949 {
	public String largestTimeFromDigits(int[] arr) {
		int hr = -1, min = -1;
		int maxHr = -1, maxMin = -1;
        for (int i = 0; i < 4; i++) {
        	for (int j = 0; j < 4; j++) {
        		if (i == j) continue;
        		hr = Integer.parseInt("" + arr[i] + arr[j]);
        		if (hr > 23) continue;
        		for (int k = 0; k < 4; k++) {
        			if (k == i || k == j) continue;
        			int l = 6 - i - j - k;
        			min = Integer.parseInt("" + arr[k] + arr[l]);
        			if (min > 59) continue;
        			if (hr > maxHr || (hr == maxHr && min > maxMin)) {
        				maxHr = hr;
        				maxMin = min;
        			}
        		}
        	}
        }
        if (maxHr == -1 || maxMin == -1) return "";
        String result = "";
        if (maxHr < 10) result += "0";
        result += maxHr + ":";
        if (maxMin < 10) result += "0";
        result += maxMin;
        return result;
    }
	
	public static void main(String[] args) {
		Problem949 problem = new Problem949();
		System.out.println(problem.largestTimeFromDigits(new int[] {1, 2, 3, 4}));
	}
}
