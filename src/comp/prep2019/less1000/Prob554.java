package comp.prep2019.less1000;
import java.util.*;
public class Prob554 {
	public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < wall.size(); i++) {
        	int sum = 0;
        	for (int j = 0; j < wall.get(i).size() - 1; j++) {
        		sum += wall.get(i).get(j);
        		int freq = map.getOrDefault(sum, 0) + 1;
        		max = Math.max(max, freq);
        		map.put(sum, freq);
        	}
        }
        return wall.size() - max;
    }
}
