package comp.prep2019;

import java.util.*;

public class Prob1288 {
	public int removeCoveredIntervals(int[][] intervals) {
        int result = intervals.length;
        Arrays.sort(intervals, 
        		(x, y) -> (x[1] == y[1]) ? (x[0] - y[0]) : (x[1] - y[1]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
        	int[] last = list.get(list.size() - 1);
        	if (last[0] <= intervals[i][0] && last[1] >= intervals[i][1]) {
        		result--;
        		continue;
        	}
        	while(!list.isEmpty()) {
        		last = list.get(list.size() - 1);
        		if (last[0] >= intervals[i][0] && last[1] <= intervals[i][1]) {
        			list.remove(list.size() - 1);
        			result--;
        		} else break;
        	}
        	list.add(intervals[i]);
        }
        return result;
    }
}
