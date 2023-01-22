package com.prep2020.hard;
import java.util.*;
public class Problem1776 {
	/**
	 * O(N)
	 * @param cars
	 * @return
	 */
	public double[] getCollisionTimes(int[][] cars) {
       int n = cars.length;
       double[] result = new double[n];
       Deque<Integer> stack = new ArrayDeque<>();
       for (int i = n - 1; i > -1; i--) {
    	   result[i] = -1;
    	   while(!stack.isEmpty()) { // Check for the next slower car
    		   int j = stack.peek();
    		   double t = expectedTimeOfCrash(cars[j], cars[i]);
    		  // Check if expected crash time, i.e. t between (j, i) is before time[j], which is crash time of j with the next car in stack
               // If car j has crashed before means (t > time[j]), then car i will not crash with j, so check if car i crashes with the next car in stack
    		   if (t > 0 && (result[j] == -1 || t <= result[j])) {
    			   result[i] = t;
    			   break;
    		   }
    		   stack.pop();
    	   }
    	   stack.push(i);
       }
       return result;
    }

	private double expectedTimeOfCrash(int[] carFront, int[] carBack) {
		if (carFront[1] < carBack[1]) return (carFront[0] - carBack[0] + 0.0) 
				/ (carBack[1] - carFront[1]);
		return -1;
	}
	
	
}
