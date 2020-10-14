package comp.prep2019;
import java.util.*;
public class Prob621 {
	/**
	 * O(N_total)
	 * @param tasks
	 * @param n
	 * @return
	 */
	public int leastInterval(char[] tasks, int n) {
		if (n == 0) return tasks.length;
        int[] arr = new int[26];
        for (char c : tasks) {
        	arr[c - 'A']++;
        }
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int i= 0; i < arr.length; i++) {
        	if (arr[i] != 0) q.offer(new int[] {i, arr[i], -1});
        }
        int time = 0;
        Queue<int[]> blocked = new LinkedList<>();
        while(!q.isEmpty() || !blocked.isEmpty()) {
        	time++;
        	if (!q.isEmpty()) {
	        	int[] cur = q.poll();
	        	cur[1]--;
	        	cur[2] = time;
	        	if (cur[1] != 0) blocked.offer(cur);
        	}
        	if (!blocked.isEmpty()) {
        		int[] peek = blocked.peek();
        		if (time - peek[2] >= n) q.offer(blocked.poll());
        	}
        }
        return time;
    }
	
	public static void main(String[] args) {
		Prob621 prob = new Prob621();
		System.out.println(prob.leastInterval(new char[] {'A',  'A', 'A', 'B', 'B', 'B'}, 2));
	}
}
