package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2187 {
	public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long min = 1l, max = (totalTrips + 0l) * (0l + time[0]);
        long result = Long.MAX_VALUE;
        while(min <= max) {
        	long mid = min + (max - min) / 2;
        	long numTrips = countTrips(time, mid);
        	if (numTrips >= totalTrips) {
        		result = mid;
        		max = mid - 1;
        	} else min = mid + 1;
        }
        return result; 
    }

	private long countTrips(int[] time, long mid) {
		long result = 0l;
		for (int i = 0; i < time.length; i++) {
			if (mid / time[i] == 0) break;
			result += (mid / time[i]);
		}
		return result;
	}
}
