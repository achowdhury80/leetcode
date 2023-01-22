package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2208 {
	public int halveArray(int[] nums) {
        double sum = 0;
        Queue<Double> pq = new PriorityQueue<>((x, y) -> (y > x ? 1 : -1));
        for (int num : nums) {
        	pq.offer(0. + num);
        	sum += num;
        }
        double target = sum / 2;
        int result = 0;
        while(sum > target) {
        	result++;
        	double cur = pq.poll();
        	cur /= 2;
        	sum -= cur;
        	pq.offer(cur);
        }
        return result;
    }
}
