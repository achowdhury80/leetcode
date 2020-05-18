package comp.prep2019;
import java.util.*;
public class Prob1442 {
	public int countTriplets(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        map.put(0, list);
        int cur = 0, result = 0;
        for (int i = 0; i < arr.length; i++) {
        	cur ^= arr[i];
        	List<Integer> l = map.getOrDefault(cur, new ArrayList<>());
        	for (int index : l) {
        		result += (i - index -1);
        	}
        	l.add(i);
        	map.put(cur, l);
        }
        return result;
    }
}
