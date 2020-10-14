package comp.prep2019.less2000;
import java.util.*;
public class Prob1383 {
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long result = -1, mod = (long)(1e9 + 7);
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int i = 0; i < n; i++) {
        	q.offer(new int[] {efficiency[i], i});
        }
        long sum = 0;
        Queue<Integer> valQ = new PriorityQueue<>();
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	valQ.offer(speed[cur[1]]);
        	sum += speed[cur[1]];
        	if (valQ.size() > k) {
        		int val = valQ.poll();
        		sum -= val;
        	}
        	result = Math.max(result, (cur[0] * sum));
        }
        return(int) (result % mod);
    }
}	
