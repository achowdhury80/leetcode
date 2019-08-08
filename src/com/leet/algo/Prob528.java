package com.leet.algo;
import java.util.*;
import java.util.Map.Entry;
public class Prob528 {
	int[] sum;
    Random random;
    public Prob528(int[] w) {
        random = new Random();
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = w[i] + sum[i - 1];
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(sum[sum.length - 1]) + 1;
        return binarySearch(target);
    }
    
    private int binarySearch(int target) {
    	int left = 0, right = sum.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == target) {
                return mid;
            }
            else if (sum[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
