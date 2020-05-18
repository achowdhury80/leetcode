package comp.prep2019;
import java.util.*;
public class Prob313 {
	public int nthSuperUglyNumber(int n, int[] primes) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i : primes) q.offer(new int[] {i, i, 0});
        int j = 1;
        int last = 1;
        while(j < n) {
        	int[] arr = q.peek();
        	last = arr[0];
        	while(!q.isEmpty() && q.peek()[0] <= last) {
        		int[] arr2 = q.poll();
        		if (arr2[2] < primes.length) {
            		q.offer(new int[] {arr2[1] * primes[arr2[2]], arr2[1], arr2[2] + 1});
            	}
        	}
        	q.offer(new int[] {last * primes[0], last, 1});
        	j++;
        }
        return last;
    }
	
	public static void main(String[] args) {
		Prob313 prob = new Prob313();
		System.out.println(prob.nthSuperUglyNumber(12, new int[] {2, 7, 13, 19}));
	}
}
