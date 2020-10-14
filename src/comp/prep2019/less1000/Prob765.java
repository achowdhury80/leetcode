package comp.prep2019.less1000;
import java.util.*;
public class Prob765 {
	public int minSwapsCouples(int[] row) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < row.length; i += 2) {
        	int group1 = row[i] % 2 == 0 ? row[i] : row[i] - 1;
        	int group2 = row[i + 1] % 2 == 0 ? row[i + 1] : row[i + 1] - 1;
        	if (group1 == group2) continue;
        	Set<Integer> set1 = map.getOrDefault(group1, new HashSet<>());
        	set1.add(group2);
        	map.put(group1, set1);
        	Set<Integer> set2 = map.getOrDefault(group2, new HashSet<>());
        	set2.add(group1);
        	map.put(group2, set2);
        }
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
        	if (visited.contains(entry.getKey())) continue;
        	if (entry.getValue().size() == 1) {
        		result++;
        		visited.add(entry.getKey());
        		visited.add(entry.getValue().iterator().next());
        	} else {
        		result += (findCycleCount(map, entry.getKey(), visited) - 1);
        	}
        }
        
        return result;
    }
	
	private int findCycleCount(Map<Integer, Set<Integer>> map, int start, Set<Integer> visited) {
		if (visited.contains(start)) return 0;
		int result = 1;
		visited.add(start);
		for (int key : map.get(start)) {
			result += findCycleCount(map, key, visited);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob765 prob = new Prob765();
		System.out.println(prob.minSwapsCouples(new int[] {1,4,0,5,8,7,6,3,2,9}));
	}
	
}
