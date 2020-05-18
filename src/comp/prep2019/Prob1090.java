package comp.prep2019;
import java.util.*;
public class Prob1090 {
	public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, 
			int use_limit) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> (y[1] - x[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
        	map.put(labels[i], map.getOrDefault(labels[i], 0) + 1);
        	q.offer(new int[] {labels[i], values[i]});
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if (entry.getValue() > use_limit) entry.setValue(use_limit);
        }
        int i = 0;
        int result = 0;
        while(!q.isEmpty()) {
        	int[] item = q.poll();
        	if (map.get(item[0]) > 0) {
        		result += item[1];
        		map.put(item[0], map.get(item[0]) - 1);
        		num_wanted--;
        		if (num_wanted == 0) return result;
        	}
        }
        return result;
    }
}
