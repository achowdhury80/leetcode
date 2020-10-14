package comp.prep2019.less1000;
import java.util.*;
public class Prob767 {
	public String reorganizeString(String S) {
        int[] arr = new int[26];
        for (char c : S.toCharArray()) {
        	arr[c - 'a']++;
        }
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] > 0) q.offer(new int[] {i, arr[i]});
        }
        StringBuilder sb = new StringBuilder();
        int[] pair = q.poll();
        sb.append((char)(pair[0] + 'a'));
        pair[1]--;
        if (pair[1] > 0) q.offer(pair);
        int last = pair[0];
        while(!q.isEmpty()) {
        	if (q.peek()[0] == last) {
        		int[] temp = q.poll();
        		if (q.isEmpty()) return "";
        		pair = q.poll();
                sb.append((char)(pair[0] + 'a'));
                pair[1]--;
                if (pair[1] > 0) q.offer(pair);
                last = pair[0];
                q.offer(temp);
        	} else {
        		pair = q.poll();
                sb.append((char)(pair[0] + 'a'));
                pair[1]--;
                if (pair[1] > 0) q.offer(pair);
                last = pair[0];
        	}
        }
        return sb.toString();
    }
}
