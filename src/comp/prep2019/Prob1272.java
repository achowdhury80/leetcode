package comp.prep2019;
import java.util.*;
public class Prob1272 {
	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		List<List<Integer>> result = new ArrayList<>();
		for (int[] interval : intervals) {
			if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
				result.add(helper(interval));
			} else {
				if (interval[0] < toBeRemoved[0]) {
					result.add(helper(new int[] {interval[0], toBeRemoved[0]}));
				}
				if (interval[1] > toBeRemoved[1]) {
					result.add(helper(new int[] {toBeRemoved[1], interval[1]}));
				}
			}
			
		}
		return result;
    }
	
	private List<Integer> helper(int[] interval) {
		List<Integer> list = new ArrayList<>();
		list.add(interval[0]);
		list.add(interval[1]);
		return list;
	}
}
