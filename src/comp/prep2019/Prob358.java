package comp.prep2019;
import java.util.*;
public class Prob358 {
	public String rearrangeString(String s, int k) {
		int[] arr = new int[26];
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        for (int i = 0; i < 26; i++) {
        	if (arr[i] > 0) pq.offer(new int[] {i, arr[i]});
        }
        Queue<int[]> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	sb.append((char)(cur[0] + (int)'a'));
        	cur[1]--;
        	q.offer(cur);
        	if(q.size() >= k) {
        		cur = q.poll();
        		if (cur[1] > 0) pq.offer(cur);
        	}
        }
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
    		if (cur[1] > 0) return "";
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Prob358 prob = new Prob358();
		System.out.println(prob.rearrangeString("a", 0));
		System.out.println(prob.rearrangeString("aa", 0));
		System.out.println(prob.rearrangeString("aabbcc", 2));
		System.out.println(prob.rearrangeString("aabbcc", 3));
	}
}
