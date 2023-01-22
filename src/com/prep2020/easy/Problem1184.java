package com.prep2020.easy;

public class Problem1184 {
	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		if (start == destination) return 0;
        int total = 0;
        for (int d : distance) total += d;
        int result = 0;
        for (int i = start; i != destination; i = (i + 1) % distance.length) {
        	result += distance[i];
        }
        return Math.min(result, total - result);
    }
}
