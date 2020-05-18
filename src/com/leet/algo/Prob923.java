package com.leet.algo;
import java.util.*;
public class Prob923 {
	public int threeSumMulti(int[] A, int target) {
		int mod = (int)(1e9 + 7);
		int[] counts = new int[101];
		for (int a : A) counts[a]++;
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0) nums.add(i);
		}
		long result = 0;
		for (int i = 0; i < nums.size(); i++) {
			int x = nums.get(i);
			int n = counts[x];
			if (n > 2 && 3 * x == target) {
				result += n * 1l * (n - 1) * (n - 2) / 6;
			} else if (n > 1) {
				int y = target - 2 * x;
				if (x != y && y >= 0 && y < 101 && counts[y] > 0) {
					result += 1l * counts[y] * n * (n - 1) / 2;
				}
			}
			int l = i + 1, r = nums.size() - 1;
			while(l < r) {
				// 2y case is solved previously
				int y = nums.get(l), z = nums.get(r);
				int sum = x + y + z;
				if (sum == target) {
					result += 1l * counts[x] * counts[y] * counts[z];
					l++;
					r--;
				} else if (sum < target) l++;
				else r--;
				
			}
			
		}
		return (int)(result % mod);
    }
	
	
}
