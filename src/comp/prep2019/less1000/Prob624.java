package comp.prep2019.less1000;
import java.util.*;
public class Prob624 {
	public int maxDistance(List<List<Integer>> arrays) {
        Queue<int[]> minQ = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        Queue<int[]> maxQ = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int i = 0; i < arrays.size(); i++) {
        	int[] min = new int[] {arrays.get(i).get(0), i};
        	maxQ.offer(min);
        	if (maxQ.size() > 2) maxQ.poll();
        	int[] max = new int[] {arrays.get(i).get(arrays.get(i).size() - 1), i};
        	minQ.offer(max);
        	if (minQ.size() > 2) minQ.poll();
        }
        int result = Integer.MIN_VALUE;
        for (int[] min : maxQ) {
        	for (int[] max : minQ) {
        		if (min[1] != max[1]) result = Math.max(result, max[0] - min[0]);
        	}
        }
        return result;
    }
}
