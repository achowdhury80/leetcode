package comp.prep2019.less2000;
import java.util.*;
public class Prob1333 {
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, 
			int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();
        for (int[] resto : restaurants) {
        	if (resto[3] > maxPrice || resto[4] > maxDistance 
        			|| (veganFriendly == 1 && resto[2] == 0)) continue;
        	list.add(new int[] {resto[0], resto[1]});
        }
        Collections.sort(list, ((x, y) -> (x[1] == y[1]) ? y[0] - x[0] : y[1] - x[1]));
        List<Integer> result = new ArrayList<>();
        for (int[] arr : list) result.add(arr[0]);
        return result;
    }
}
