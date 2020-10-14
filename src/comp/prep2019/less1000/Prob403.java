package comp.prep2019.less1000;
import java.util.*;
public class Prob403 {
	/**
	 * O(N^2) time and space
	 * maintain a dp (map). key is position and value is a set which contains jump 
	 * size to reach there
	 * map.put(0, {0})
	 * starting from 0, find all next position. if the position has stone, add last
	 * jump size in the postion's set
	 * check if you reached the last position 
	 * @param stones
	 * @return
	 */
	public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
        	map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length - 1; i++) {
        	for (int jump : map.get(stones[i]))  {
        		for (int k = Math.max(1, jump - 1); k < jump + 2; k++) {
        			if (map.containsKey(stones[i] + k)) {
        				map.get(stones[i] + k).add(k);
        				if (stones[i] + k == stones[stones.length - 1]) return true;
        			}
        		}
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		Prob403 prob = new Prob403();
		System.out.println(prob.canCross(new int[] {0, 1, 3, 4, 5, 7, 9, 10, 12}));
	}
}
