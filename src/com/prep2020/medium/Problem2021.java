package com.prep2020.medium;
import java.util.*;
public class Problem2021 {
	/**
	 * O(NlogN)
	 * @param lights
	 * @return
	 */
	public int brightestPosition(int[][] lights) {
      int location = -1, brightness = 0; 
      Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] == y[0] 
    		  ? (x[1] - y[1]) : (x[0] - y[0]));
      for (int[] light : lights) {
    	  pq.offer(new int[] {light[0] - light[1], 0});
    	  pq.offer(new int[] {light[0] + light[1], 1});
      }
      int open = 0;
      while(!pq.isEmpty()) {
    	  int[] arr = pq.poll();
    	  if (arr[1] == 0) {
    		  open++;
    		  if (open > brightness) {
    			  location = arr[0];
    			  brightness = open;
    		  }
    	  } else open--;
      }
      return location;
    }
}
