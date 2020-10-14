package comp.prep2019.less2000;
import java.util.*;
public class Prob1354 {
	public boolean isPossible(int[] target) {
		if (target.length == 1) {
			if (target[0] != 1) return false;
			return true;
		}
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        int sum = 0;
        for (int i : target) {
        	sum += i;
        	q.offer(i);
        }
        while(sum > target.length) {
        	int max = q.poll();
        	sum = sum - max;
        	if (sum >= max) return false;
        	if (sum == 1) return true;
        	int rem = max % sum;
        	if (rem == 0) return false;
        	q.offer(rem);
        	sum += rem;
        }
        
        return sum == target.length;
    }
	
	public static void main(String[] args) {
		Prob1354 prob = new Prob1354();
		//System.out.println(prob.isPossible(new int[] {9, 3, 5}));
		
		//System.out.println(prob.isPossible(new int[] {8, 5}));
		System.out.println(prob.isPossible(new int[] {2,900000002}));
	}
}
