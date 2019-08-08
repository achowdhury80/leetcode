package com.leet.algo;
import java.util.*;
public class Prob1054 {
	/**
	 * O(n log n) and O(n)
	 * find the code freq and save it in map
	 * put all the map entries in max heap
	 * keep taking the max freq item from the heap
	 * put the item in result and decrease the feq by 1.
	 * keep the updated entry in a queue.
	 * take the last loaded entry from the q and if it's freq is more than 1 then add it back to heap 
	 * @param barcodes
	 * @return
	 */
	public int[] rearrangeBarcodes(int[] barcodes) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int barcode : barcodes) map.put(barcode, map.getOrDefault(barcode, 0) + 1);
       PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
       for (Map.Entry<Integer, Integer> entry : map.entrySet()) pq.offer(entry);
       Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
       int[] result = new int[barcodes.length];
       int i = 0;
       while(!pq.isEmpty()) {
    	   Map.Entry<Integer, Integer> entry = pq.poll();
    	   result[i++] = entry.getKey();
    	   entry.setValue(entry.getValue() - 1);
    	   q.offer(entry);
    	   if (q.size() > 1) {
	    	   Map.Entry<Integer, Integer> last = q.poll();
	    	   if (last.getValue() > 0) pq.offer(last);
    	   }
       }
       return result;
    }
}
