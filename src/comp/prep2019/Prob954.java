package comp.prep2019;
import java.util.*;
public class Prob954 {
	/*
	 * o(n) time and space
	 * first sort
	 * put the counts in map
	 * look for even zeros
	 * two pass - one for -1 to min and other for 1 to max
	 */
	public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int a : A) {
        	map.put(a, map.getOrDefault(a, 0) + 1);
        	min = Math.min(min, a);
        	max = Math.max(max, a);
        }
        if (map.containsKey(0) && map.get(0) % 2 != 0) return false;
        if (min < 0 && !helper(-1, min, map, -1)) return false;
        if (max > 0 && !helper(1, max, map, 1)) return false;
        return true;
    }
	
	private boolean helper(int start, int end, Map<Integer, Integer> map, int dir) {
		for (int i = start; Math.abs(i) <= Math.abs(end); i = i + dir) {
        	if (!map.containsKey(i) || map.get(i) == 0) continue;
        	if (!map.containsKey(2 * i) || map.get(2 * i) < map.get(i)) {
        		return false;
        	}
        	map.put(2 * i, map.get(2 * i) - map.get(i));
        }
        return true;
	}
	
	public static void main(String[] args) {
		Prob954 prob = new Prob954();
		//System.out.println(prob.canReorderDoubled(new int[] {4, -2, 2, -4}));
		System.out.println(prob.canReorderDoubled(new int[] {-5, -3}));
	}
}
