package com.prep2020.medium;
import java.util.*;
public class Problem853 {
	/**
	 * O(nlogN)
	 * @param target
	 * @param position
	 * @param speed
	 * @return
	 */
	public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) 
        	list.add(new int[] {position[i], speed[i]});
        Collections.sort(list, (x, y) -> y[0] - x[0]);
        int result = 0;
        double lastTime = 0;
        for (int[] a : list) {
        	double time = (target + 0. - a[0]) / a[1];
        	if (time > lastTime) {
        		result++;
        		lastTime = time;
        	}
        }
        return result;
    }
}
