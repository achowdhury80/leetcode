package comp.prep2019.less2000;
import java.util.*;
public class Prob1282 {
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++) {
			if (map.containsKey(groupSizes[i])) {
				map.get(groupSizes[i]).add(i);
				if (map.get(groupSizes[i]).size() == groupSizes[i]) {
					result.add(map.get(groupSizes[i]));
					map.remove(groupSizes[i]);
				}
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				if (groupSizes[i] == 1) result.add(list);
				else map.put(groupSizes[i], list);
			}
		}
		return result;
    }
}
