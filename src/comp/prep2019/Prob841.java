package comp.prep2019;
import java.util.*;
public class Prob841 {
	/**
	 * O(N) time and space
	 * @param rooms
	 * @return
	 */
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		// arr[i] true means ith room is accessible
        boolean[] arr = new boolean[1001];
        arr[0] = true;
        int opened = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()) {
        	int room = q.poll();
        	List<Integer> keys = rooms.get(room);
        	if (keys != null && !keys.isEmpty()) {
        		for (int key : keys) {
        			if (!arr[key]) {
        				arr[key] = true;
        				opened++;
        				q.offer(key);
        			}
        		}
        	}
        }
        return opened == rooms.size();
    }
}
