package comp.prep2019;
import java.util.*;
public class Prob1338 {
	public int minSetSize(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (x, y) -> y.getValue() - x.getValue());
        int count = 0, result = 0;
        for (int i = 0; i < arr.length && count < arr.length / 2; i++) {
        	result++;
        	count += list.get(i).getValue();
        }
        return result;
    }
}
