package comp.prep2019.less1000;
import java.util.*;
public class Prob386 {
	public List<Integer> lexicalOrder(int n) {
        if (n < 1) return new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>((x, y) -> ("" + x).compareTo("" + y));
        q.offer(1);
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        used[1] = true;
        while(!q.isEmpty()) {
        	int cur = q.poll();
        	result.add(cur);
        	if(cur + 1 <= n && !used[cur + 1]) {
                q.offer(cur + 1);
                used[cur + 1] = true;
        	}
        	if (cur * 10 <= n && !used[cur * 10]) {
        		q.offer(cur * 10);
        		used[cur * 10] = true;
        	}
        }
        return result; 
    }
}
