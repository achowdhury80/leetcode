package comp.prep2019;

import java.util.HashMap;
import java.util.Map;

public class Prob149 {
	public int maxPoints(int[][] points) {
		if (points == null || points.length < 2) return points.length;
	    int result = 0;
	    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
	    for (int i = 0; i < points.length - 1; i++) {
	    	map.clear();
	    	int samePoint = 0, max = 0;
	    	for (int j = i + 1; j < points.length; j++) {
	    		int x = points[i][0] - points[j][0];
	    		int y = points[i][1] - points[j][1];
	    		if (x == 0 && y == 0) samePoint++;
	    		else {
	    			int hcf = gcd(x, y);
	    			if (hcf != 0) {
	    				x /= hcf;
	    				y /= hcf;
	    			}
	    			if (map.containsKey(x)) {
	    	            if (map.get(x).containsKey(y)) {
	    	              map.get(x).put(y, map.get(x).get(y) + 1);
	    	            } else map.get(x).put(y, 1);
	    	          } else {
	    	            Map<Integer, Integer> m = new HashMap<>();
	    	            m.put(y, 1);
	    	            map.put(x, m);
	    	          }
	    	          max = Math.max(max, map.get(x).get(y));
	    		}
	    		
	    	}
	    	result = Math.max(result, max + samePoint + 1);
	    }
	    return result;
    }
	
	int gcd(int a, int b) {
		  return a == 0 ? b : gcd(b % a, a);
	}
	
	public static void main(String[] args) {
		Prob149 prob = new Prob149();
		System.out.println(prob.maxPoints(new int[][] {{1,1},{2,2},{3,3}}));
	}
}
