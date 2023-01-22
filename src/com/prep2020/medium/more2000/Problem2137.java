package com.prep2020.medium.more2000;

public class Problem2137 {
	public double equalizeWater(int[] buckets, int loss) {
		double low = 0, high = 100_000, retainPercent = (100.0 - loss) / 100;
        while(high - low > 0.00001) {
        	double mid = low + (high - low) / 2, need = 0, have = 0;
        	for (int b : buckets) {
        		if (b >= mid) have += b - mid;
        		else need += mid -b;
        	}
        	if (have * retainPercent >= need) low = mid;
        	else high = mid;
        }
        return low;
    }
	
	public static void main(String[] args) {
		Problem2137 problem = new Problem2137();
		System.out.println(problem.equalizeWater(new int[]{1, 2, 7}, 80));
	}
}
