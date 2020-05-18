package comp.prep2019;
import java.util.*;
public class Prob1182 {
	public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        TreeSet<Integer>[] arr = new TreeSet[3];
        arr[0] = new TreeSet<>();
        arr[1] = new TreeSet<>();
        arr[2] = new TreeSet<>();
        for (int i = 0; i < colors.length; i++) {
        	arr[colors[i] - 1].add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
        	result.add(search(arr, q));
        }
        return result;
        
    }
	
	private int search(TreeSet<Integer>[] arr, int[] q) {
		TreeSet<Integer> ts = arr[q[1] - 1];
		if (ts.isEmpty()) return -1;
		if (ts.contains(q[0])) return 0;
		Integer smaller = ts.floor(q[0]);
		Integer greater = ts.ceiling(q[0]);
		if (smaller == null) return greater - q[0];
		else if (greater == null) return q[0] - smaller;
		return Math.min(greater - q[0], q[0] - smaller);
		
	}
}
