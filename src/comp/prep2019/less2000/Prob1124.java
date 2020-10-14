package comp.prep2019.less2000;

import java.util.HashMap;
import java.util.Map;

public class Prob1124 {
	public int longestWPI(int[] hours) {
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
        	sum += (hours[i] > 8 ? 1 : -1);
        	if (sum > 0) result = i + 1;
        	else {
        		// sum is negative
        		map.putIfAbsent(sum, i);
        		/*
        		 *  lets say sum = -5
        		 *  we are supposed check with -6 
        		 *  if we are to check with -7, meaning -6 and -5 came before
        		 *  can't check with -4.
        		 */
        		
        		if (map.containsKey(sum - 1))
        			result = Math.max(result, i - map.get(sum - 1));
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1124 prob = new Prob1124();
		System.out.println(prob.longestWPI(new int[] {6,9,9}));
	}
}
