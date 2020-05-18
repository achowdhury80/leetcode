package comp.prep2019;
import java.util.*;
public class Prob1331 {
	public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];
        int[] result = new int[arr.length];
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < arr.length; i++) q.offer(new int[] {arr[i], i});
        int[] cur = q.poll();
        int rank = 1, prev = cur[0];
        result[cur[1]] = rank;
        while(!q.isEmpty()) {
        	cur = q.poll();
        	if (prev != cur[0]) rank++;
        	prev = cur[0];
        	result[cur[1]] = rank;
        }
        return result;
    }
}
