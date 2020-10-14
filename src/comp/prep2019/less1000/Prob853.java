package comp.prep2019.less1000;
import java.util.*;
public class Prob853 {
	public int carFleet(int target, int[] position, int[] speed) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int i = 0; i < speed.length; i++) {
        	q.offer(new int[] {position[i], speed[i]});
        }
        int result = 0;
        double time = Double.MIN_VALUE;
        while(!q.isEmpty()) {
        	int[] arr = q.poll();
        	double newTime = (target - arr[0] + 0.0) / arr[1];
        	if (newTime > time) {
        		result++;
        		time = newTime;
        	}
        }
        return result;
    }
}
