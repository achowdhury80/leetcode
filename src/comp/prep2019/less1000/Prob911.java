package comp.prep2019.less1000;
import java.util.*;
public class Prob911 {
	private TreeMap<Integer, Integer> treeMap;
	Map<Integer, Integer> map;
	public Prob911(int[] persons, int[] times) {
		treeMap = new TreeMap<>();
		map = new HashMap<>();
		int[] max = new int[] {-1, -1};
		for (int i = 0; i < persons.length; i++) {
			map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
			int count = map.get(persons[i]);
			if (count >= max[0]) {
				max = new int[] {count, persons[i]};
			}
			treeMap.put(times[i], max[1]);
		}
    }
    
    public int q(int t) {
        return treeMap.floorEntry(t).getValue();
    }
}
