package comp.prep2019.less1000;
import java.util.*;
public class Prob786 {
	public int[] kthSmallestPrimeFraction(int[] A, int K) {
        Queue<int[]> q = new PriorityQueue<>((x, y) -> 
        	(A[x[0]] * A[y[1]] - A[y[0]] * A[x[1]]));
        for (int i = 1; i < A.length; i++) q.offer(new int[] {0, i});
        int n = 0;
        int[] arr = null;
        while(n < K - 1) {
        	arr = q.poll();
        	arr[0]++;
        	if(arr[1] > arr[0]) q.offer(arr);
        	n++;
        }
        return new int[] {A[q.peek()[0]], A[q.peek()[1]]};
    }
	
	public static void main(String[] args) {
		Prob786 prob = new Prob786();
		System.out.println(prob.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 3));
	}
}
