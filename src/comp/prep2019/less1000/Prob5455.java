package comp.prep2019.less1000;
import java.util.*;
public class Prob5455 {
	public int minDays(int[] bloomDay, int m, int k) {
        long sum = 0;
        TreeMap<Integer, List<Integer>> flowerDay = new TreeMap<>();
        for (int i = 0; i < bloomDay.length; i++) {
        	List<Integer> indices = flowerDay.getOrDefault(bloomDay[i], new ArrayList<>());
        	indices.add(i);
        	flowerDay.put(bloomDay[i], indices);
        }
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : flowerDay.entrySet()) {
        	for (int index : entry.getValue()) {
        		int[] interval = new int[] {index, 1};
        		Map.Entry<Integer, Integer> lower = intervals.lowerEntry(index);
        		if (lower != null && lower.getKey() + lower.getValue() == index) {
        			sum -= lower.getValue() / k;
        			interval = new int[] {lower.getKey(), lower.getValue() + 1};
        			intervals.remove(lower.getKey());
        		}
        		Map.Entry<Integer, Integer> upper = intervals.higherEntry(index);
        		if (upper != null && upper.getKey() == index + 1) {
        			sum -= upper.getValue() / k;
        			interval = new int[] {interval[0], interval[1] + upper.getValue()};
        			intervals.remove(upper.getKey());
        		}
        		sum += interval[1] / k;
        		if (sum >= m) return entry.getKey();
        		intervals.put(interval[0], interval[1]);
        	}
        	
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Prob5455 prob = new Prob5455();
		System.out.println(prob.minDays(new int[] {7,7,7,7,12,7,7}, 2, 3));
	}
}
