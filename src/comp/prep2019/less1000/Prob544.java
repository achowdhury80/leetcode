package comp.prep2019.less1000;
import java.util.*;
public class Prob544 {
	public String findContestMatch(int n) {
        Deque<String> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
        	dq.addLast("" + i);
        }
        while(dq.size() > 1) {
        	Deque<String> temp = new ArrayDeque<>();
        	while(!dq.isEmpty()) {
        		temp.addLast("(" + dq.pollFirst() + "," + dq.pollLast() + ")");
        	}
        	dq = temp;
        }
        return dq.poll();
    }
}
