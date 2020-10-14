package comp.prep2019.less1000;

import java.util.*;

public class Prob857 {
	public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
		Integer[] arr = new Integer[quality.length];
        for (int i = 0; i < quality.length; i++) {
        	arr[i] = i;
        }
        Arrays.sort(arr, (x, y) -> Double.compare((wage[x] + 0.0) / quality[x],
        		(wage[y] + 0.0) / quality[y])); 
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        int sumQ = 0;
        double result = Integer.MAX_VALUE;
        for (int i : arr) {
        	sumQ += quality[i];
        	if (q.size() == K) sumQ -= q.poll();
        	q.offer(quality[i]);
        	if (q.size() == K) {
        		result = Math.min(result, (wage[i] + 0.0) / quality[i] * sumQ);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob857 prob = new Prob857();
		//System.out.println(prob.mincostToHireWorkers(new int[] {10, 20, 5}, new int[] {70, 50, 30}, 2));
		System.out.println(prob.mincostToHireWorkers(new int[] {4, 4, 4, 5}, 
				new int[] {13, 12, 13, 12}, 2));
	}
}
