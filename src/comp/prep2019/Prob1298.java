package comp.prep2019;
import java.util.*;
public class Prob1298 {
	/**
	 * BFS
	 * set whenever you get a key, set status to 1
	 * maintain a set of acquired box set
	 * maintain a queue to add open boxes
	 * for each open box, add number of candies to result
	 * find all the key, set status of those boxes to 1. the boxes which already 
	 * collected and status is just set to 1, add them to queue
	 * find all the contained boxes, if status is 1, add them to queue
	 * else add them to boxSet
	 * @param status
	 * @param candies
	 * @param keys
	 * @param containedBoxes
	 * @param initialBoxes
	 * @return
	 */
	public int maxCandies(int[] status, int[] candies, int[][] keys, 
			int[][] containedBoxes, int[] initialBoxes) {
		Queue<Integer> q = new LinkedList<>();
		int result = 0;
		Set<Integer> boxSet = new HashSet<>();
		for (int box : initialBoxes) {
			if (status[box] == 1) {
				q.offer(box);
			} else boxSet.add(box);
		}
		while(!q.isEmpty()) {
			int box = q.poll();
			result += candies[box];
			for (int key : keys[box]) {
				status[key] = 1;
				if (boxSet.contains(key)) {
					q.offer(key);
					boxSet.remove(key);
				}
			}
			for (int containedBox : containedBoxes[box]) {
				if (status[containedBox] == 1) {
					q.offer(containedBox);
					boxSet.remove(containedBox);
				} else boxSet.add(containedBox);
			}
		}
		return result;
    }
}
