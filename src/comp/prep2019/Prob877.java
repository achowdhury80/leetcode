package comp.prep2019;
import java.util.*;
public class Prob877 {
	public boolean stoneGame(int[] piles) {
        return stoneGame(piles, 0, piles.length - 1, new HashMap<>()) > 0;
    }
	
	private int stoneGame(int[] piles, int start, int end, Map<String, Integer> map) {
		String key = start + "-" + end;
        if (map.containsKey(key)) return map.get(key);
        if (start == end) {
        	map.put(key, piles[start]);
        	return piles[start];
        }
        int leftSelected = piles[start] - stoneGame(piles, start + 1, end, map);
        int rightSelected = piles[end] - stoneGame(piles, start, end - 1, map);
        if (leftSelected > rightSelected) map.put(key, leftSelected);
        else map.put(key, rightSelected);
        return map.get(key);
    }
}
