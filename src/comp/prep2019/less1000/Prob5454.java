package comp.prep2019.less1000;
import java.util.*;
public class Prob5454 {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : arr) freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        int result = freqMap.size();
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((x, y) -> x.getValue() - y.getValue());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
        	q.offer(entry);
        }
        int removed = 0;
        while (k > 0) {
        	q.peek().setValue(q.peek().getValue() - 1);
        	if (q.peek().getValue() == 0) {
        		removed++;
        		q.poll();
        	}
        	k--;
        }
        return result - removed;
    }
	
	public static void main(String[] args) {
		Prob5454 prob = new Prob5454();
		System.out.println(prob.findLeastNumOfUniqueInts(new int[] {2, 1, 1, 3, 3, 3}, 2));
	}
}
