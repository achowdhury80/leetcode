package comp.prep2019;
import java.util.*;
public class Prob763 {
	/**
	 * O(NlogN)
	 * @param S
	 * @return
	 */
	public List<Integer> partitionLabels(String S) {
        int[][] arr = new int[26][];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
        	char c = chars[i];
        	int idx = c - 'a';
        	if (arr[idx] == null) arr[idx] = new int[] {i, i};
        	else arr[idx][1] = i;
        }
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] != null) q.offer(arr[i]);
        }
        List<Integer> result = new ArrayList<>();
        int[] cur = q.poll();
        while(!q.isEmpty()) {
        	int[] interval = q.poll();
        	if (interval[0] < cur[1]) {
        		cur[1] = Math.max(cur[1], interval[1]);
        	} else {
        		result.add(cur[1] - cur[0] + 1);
        		cur = interval;
        	}
        }
        result.add(cur[1] - cur[0] + 1);
        return result;
    }
}
