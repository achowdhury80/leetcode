package comp.prep2019;
import java.util.*;
public class Prob621 {
	public int leastInterval(char[] tasks, int n) {
		if (n == 0) return tasks.length;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);
        // int[] of 3 elements, 1st -> task name, 2nd count, 3rd blocked interval
        Queue<int[]> pq = new PriorityQueue<int[]>((x, y) -> y[1] - x[1]);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        	pq.offer(new int[] {entry.getKey(), entry.getValue(), 0});
        }
        List<int[]> blocked = new ArrayList<>();
        while(!pq.isEmpty() || !blocked.isEmpty()) {
        	if (!pq.isEmpty()) {
        		int[] arr = pq.poll();
        		arr[1]--;
        		if (arr[1] != 0) {
        			arr[2] = n + 1;
        			blocked.add(arr);
        		}
        	}
        	List<int[]> temp = new ArrayList<>();
        	for (int[] a : blocked) {
        		a[2]--;
        		if (a[2] == 0) pq.offer(a);
        		else temp.add(a);
        	}
        	blocked = temp;
        	result++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob621 prob = new Prob621();
		System.out.println(prob.leastInterval(new char[] {'A',  'A', 'A', 'B', 'B', 'B'}, 2));
	}
}
