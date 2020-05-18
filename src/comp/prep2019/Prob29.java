package comp.prep2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob29 {
	public int divide(int dividend, int divisor) {
	    if(dividend == 0) return 0;
	    long x = dividend, y = divisor;
	    boolean positive = true;
	    if(x < 0 && y < 0){
	      x = 0l - x;
	      y = 0l - y;
	    }  else if(x < 0){
	      positive = false;
	      x = 0 - x;
	    } else if(y < 0){
	      positive = false;
	      y = 0 - y;
	    }
	    if(x < y) return 0;
	    long sum = y;
	    long lastSum = sum;
	    int result = 1;
	    long lastResult = 1;
	    Map<Long, Integer> map = new HashMap<>();
	    while(sum < x){
	      map.put(sum, result);
	      lastSum = sum;
	      lastResult = result;
	      sum = sum + sum;
	      result = result + result;
	    }
	    long[] arr = map.keySet().stream().mapToLong(a -> a).toArray();
	    Arrays.sort(arr);
	    lastSum = x - lastSum;
	    if(lastSum == 0) return findResult(lastResult, positive);
	    while(lastSum >= y){
	      long nearest = findNearestSmallest(arr, lastSum);
	      lastResult += map.get(nearest);
	      lastSum -= nearest;
	    }
	    return findResult(lastResult, positive);
	  }

	  private int findResult(long result, boolean positive){
	    if(!positive) result = 0 - result;
	    if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
	    return (int)result;
	  }

	  private long findNearestSmallest(long[] arr, long x){
	    int start = 0;
	    int end = arr.length - 1;
	    while(start <= end){
	      if(start == end) return arr[start];
	      int mid = (start + end) / 2;
	      if(arr[mid] == x) return arr[mid];
	      if(arr[mid] > x) end = mid - 1;
	      else {
	        if(arr[mid + 1] > x) return arr[mid];
	        start = mid + 1;
	      }
	    }
	    return -1;
	  }
}
