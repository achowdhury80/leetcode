package comp.prep2019;
import java.util.*;
public class Prob373 {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums1.length < 1 || nums2.length < 1) return result;
        Queue<int[]> q = new PriorityQueue<>((x, y) -> nums1[x[0]] + nums2[x[1]] - nums1[y[0]] - nums2[y[1]]);
        for (int i = 0; i < Math.min(nums1.length,  k); i++) {
        	for (int j = 0; j < Math.min(nums2.length, k); j++) q.offer(new int[] {i, j});
        }
        while(!q.isEmpty() && k > 0) {
        	int[] cur = q.poll();
        	List<Integer> list = new ArrayList<>();
        	list.add(nums1[cur[0]]);
        	list.add(nums2[cur[1]]);
        	result.add(list);
        	k--;
        }
        return result;
    }
}
