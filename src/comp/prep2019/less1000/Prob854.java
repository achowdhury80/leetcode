package comp.prep2019.less1000;
import java.util.*;
public class Prob854 {
	public int kSimilarity(String A, String B) {
        Queue<String> q = new LinkedList<>();
        q.offer(A);
        Map<String, Integer> map = new HashMap<>();
        map.put(A, 0);
        while(!q.isEmpty()) {
        	String s = q.poll();
        	if (s.equals(B)) return map.get(s);
        	List<String> neighboors = findNeighbors(s, B);
        	if (neighboors.size() > 0) {
        		for (String t : neighboors) {
        			if (!map.containsKey(t)) {
        				map.put(t, map.get(s) + 1);
        				q.offer(t);
        			}
        		}
        	}
        }
        throw null;
    }
	
	private List<String> findNeighbors(String s, String target) {
		int i = 0;
		for (; i < s.length(); i++) {
			if (s.charAt(i) != target.charAt(i)) break;
		}
		List<String> result = new ArrayList<>();
		char[] arr = s.toCharArray();
		for (int j = i + 1; j < s.length(); j++) {
			if (target.charAt(i) == arr[j]) {
				swap(arr, i, j);
				result.add(new String(arr));
				swap(arr, j, i);
			}
		}
		return result;
	}
	
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
