package comp.prep2019;
import java.util.*;
public class Prob1274 {
	public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
		if (!sea.hasShips(topRight, bottomLeft)) return 0;
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;
        int result = 0;
        for (int[][] div : findDivisions(topRight, bottomLeft)) {
        	result += countShips(sea, div[0], div[1]);
        }
        return result;
    }
	
	private List<int[][]> findDivisions(int[] topRight, int[] bottomLeft) {
		List<int[][]> result = new ArrayList<>();
		int midX = bottomLeft[0] + (topRight[0] - bottomLeft[0]) / 2;
		int midY = bottomLeft[1] + (topRight[1] - bottomLeft[1]) / 2;
		if (topRight[0] == bottomLeft[0]) {
			result.add(new int[][] {new int[] {bottomLeft[0], midY}, bottomLeft});
			result.add(new int[][] {topRight, new int[] {bottomLeft[0], midY + 1}});
        }
		else if (topRight[1] == bottomLeft[1]) {
			result.add(new int[][] {new int[] {midX, bottomLeft[1]}, bottomLeft});
			result.add(new int[][] {topRight, new int[] {midX + 1, bottomLeft[1]}});
        } else {
        	result.add(new int[][] {new int[] {midX, midY}, bottomLeft});
			result.add(new int[][] {new int[] {topRight[0], midY}, new int[] {midX + 1, bottomLeft[1]}});
        	result.add(new int[][] {new int[] {midX, topRight[1]}, new int[] {bottomLeft[0], midY + 1}});
			result.add(new int[][] {topRight, new int[] {midX + 1, midY + 1}});
        }
        return result;
	}
	
	class Sea {
		public boolean hasShips(int[] topRight, int[] bottomLeft) {
	    	 return false;
	    }
	}
}
