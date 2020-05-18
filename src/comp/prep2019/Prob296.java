package comp.prep2019;
import java.util.*;
public class Prob296 {
	public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 1) {
        			x.add(i);
        			y.add(j);
        		}
        	}
        }
        return getMinDist(x) + getMinDist(y);
    }
	
	private int getMinDist(List<Integer> list) {
		Collections.sort(list);
		int i = 0, j = list.size() - 1;
		int result = 0;
		while(i < j) result += list.get(j--) - list.get(i++);
		return result;
	}
}
