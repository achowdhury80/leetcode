package comp.prep2019;
import java.util.*;
public class Prob826 {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> (x[1] == y[1]) ? (x[0] - y[0]) : (y[1] - x[1]));
        for (int i = 0; i < profit.length; i++) q.offer(new int[] {difficulty[i], profit[i]});
        Arrays.sort(worker);
        int result = 0;
        for (int i = worker.length - 1; i > -1; i--) {
        	while(!q.isEmpty() && q.peek()[0] > worker[i]) q.poll();
        	if(q.isEmpty()) break;
        	result += q.peek()[1];
        }
        return result;
    }
}
