package com.prep2020.medium;

public class Problem365 {
	public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		if (targetCapacity > (jug1Capacity + jug2Capacity)) return false;
        return targetCapacity % hcf(jug1Capacity, jug2Capacity) == 0;
    }
	private int hcf(int a, int b) {
		if (b == 0) return a;
		if (b > a) return hcf(b, a);
		return hcf(b, a % b);
	}
}


