package comp.prep2019.less1000;

import java.util.HashMap;
import java.util.Map;

public class Prob447 {
	/**
	 * O(N^2) time and space
	 * @param points
	 * @return
	 */
	public int numberOfBoomerangs(int[][] points) {
	    if(points == null || points.length < 3) return 0;
	    int result = 0;
	    for(int i = 0; i < points.length; i++){
	      Map<Integer, Integer> map = new HashMap<>();
	      for( int j = 0; j < points.length; j++){
	        int xDif = points[i][0] - points[j][0];
	        int yDif = points[i][1] - points[j][1];
	        int distance =xDif * xDif + yDif * yDif;
	        map.put(distance, map.getOrDefault(distance, 0) + 1);
	      }
	      for(int val : map.values()){
	        result += val * (val - 1);
	      }
	    }
	    return result;
	  }
}
