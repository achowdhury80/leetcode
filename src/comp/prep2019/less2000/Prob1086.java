package comp.prep2019.less2000;
import java.util.*;
public class Prob1086 {
	/*
	 * O(N) time and space
	 */
	public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
        	Queue<Integer> q = map.getOrDefault(item[0], new PriorityQueue<>());
        	q.offer(item[1]);
        	if (q.size() > 5) q.poll();
        	map.put(item[0], q);
        }
        int[][] result = new int[map.size()][2];
        int id = 0;
        for (int key : map.keySet()) {
        	result[id][0] = key;
        	Queue<Integer> q = map.get(key);
        	int count = q.size();
        	int sum = 0;
        	while(!q.isEmpty()) sum += q.poll();
        	result[id][1] = sum / count;
        	id++;
        }
        return result;
    }
}
