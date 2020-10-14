package comp.prep2019.less1000;
import java.util.*;
public class Prob632 {
	public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> nums.get(x[0]).get(x[1]) 
        		- nums.get(y[0]).get(y[1]));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
        	q.offer(new int[] {i, 0});
        	max = Math.max(max, nums.get(i).get(0));
        }
        int[] peek = q.peek();
        int[] result = new int[] {nums.get(peek[0]).get(peek[1]), max};
        if (result[0] == result[1]) return result;
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	if (nums.get(cur[0]).size() == cur[1] + 1) break;
        	int[] next = new int[] {cur[0], cur[1] + 1};
        	q.offer(next);
        	max = Math.max(max, nums.get(next[0]).get(next[1]));
        	peek = q.peek();
        	int[] newRange = new int[] {nums.get(peek[0]).get(peek[1]), max};
        	if (newRange[1] - newRange[0] < result[1] - result [0]) result = newRange;
        	if (result[0] == result[1]) return result;
        }
        return result;
        
    }
}
