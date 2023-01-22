package com.prep2020.medium;

public class Problem1826 {
	public int badSensor(int[] sensor1, int[] sensor2) {
        for (int i = 0; i < sensor1.length; i++) {
        	if (sensor1[i] != sensor2[i]) {
        		boolean firstEqual = isEqual(sensor1, sensor2, i, i + 1, sensor1.length - i - 1);
        		boolean secondEqual = isEqual(sensor1, sensor2, i + 1, i, sensor1.length - i - 1);
        		if (firstEqual && !secondEqual) return 1;
        		else if (!firstEqual && secondEqual) return 2;
        		return -1;
        	}
        }
        return -1;
    }
	
	private boolean isEqual(int[] s1, int[] s2, int s1Start, int s2Start, int length) {
		for (int i = 0; i < length; i++) {
			if (s1[s1Start + i] != s2[s2Start + i]) return false;
		}
		return true;
	}
}
