package comp.prep2019.less1000;

import java.util.*;

public class Prob56 {
	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> (x[1] == y[1] ? (x[0] - y[0]) : (x[1] - y[1])));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
        	int[] interval = intervals[i];
        	if (list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]) list.add(interval);
        	else {
        		while(!list.isEmpty() && list.get(list.size() - 1)[1] >= interval[0]) {
        			int[] existing = list.get(list.size() - 1);
        			interval[0] = Math.min(existing[0], interval[0]);
        			list.remove(list.size() - 1);
        		}
        		list.add(interval);
        	}
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
