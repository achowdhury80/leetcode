package comp.prep2019.less2000;
import java.util.*;
public class Prob1207 {
	/**
	 * O(N) time and space
	 * @param arr
	 * @return
	 */
	public boolean uniqueOccurrences(int[] arr) {
        int[] data = new int[2001];
        for (int i : arr) {
        	data[i + 1000]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int val : data) {
        	if(val == 0) continue;
        	if (set.contains(val)) return false;
        	set.add(val);
        }
        return true;
    }
}
