package comp.prep2019.less1000;
import java.util.*;
public class Prob984 {
	public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if(A > 0) q.offer(new int[] {A, 0});
        if(B > 0) q.offer(new int[] {B, 1});
        int[] lastTwo = new int[] {-1,-1};
        while(!q.isEmpty()) {
        	int[] arr = q.poll();
        	if (lastTwo[0] == lastTwo[1] && lastTwo[1] == arr[1]) {
        		int[] temp = arr;
        		arr = q.poll();
        		q.offer(temp);
        	} 
        	lastTwo[0] = lastTwo[1];
        	lastTwo[1] = arr[1];
        	sb.append((char)(arr[1] + 'a'));
        	arr[0]--;
        	if (arr[0] > 0) q.offer(arr);
        }
        return sb.toString();
    }
}
