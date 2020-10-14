package comp.prep2019.less1000;
import java.util.*;
public class Prob599 {
	/**
	 * O(NlogN) & O(N) space
	 * @param list1
	 * @param list2
	 * @return
	 */
	public String[] findRestaurant(String[] list1, String[] list2) {
		// create a map of restaurant and its index in list1
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
        	map.put(list1[i], i);
        }
        // the element of array in q - 0th element is the index in list1
        // 1st element is the sum of indexes in list1 and list2 for a restaurant
        // we are trying to get min sum
        Queue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (int i = 0; i < list2.length; i++) {
        	if (map.containsKey(list2[i])) {
        		int idx;
        		q.offer(new int[] {(idx = map.get(list2[i])), idx + i});
        	}
        }
        List<String> list = new ArrayList<>();
        // first one is with the min index sum
        int[] arr = q.poll();
        list.add(list1[arr[0]]);
        int sum = arr[1];
        // check if any wxists with same index sum
        while(!q.isEmpty() && q.peek()[1] == sum) {
        	list.add(list1[q.poll()[0]]);
        }
        return list.toArray(new String[0]);
    }
}
