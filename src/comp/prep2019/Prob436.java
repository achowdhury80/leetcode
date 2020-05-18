package comp.prep2019;
import java.util.Map;
import java.util.TreeMap;

public class Prob436 {
	public int[] findRightInterval(int[][] intervals) {
	    if (intervals == null || intervals.length < 1) return new int[0];
	    if (intervals.length < 2) return new int[]{-1};
	    int[] result = new int[intervals.length];
	    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
	    for(int i = 0; i < intervals.length; i++){
	      treeMap.put(intervals[i][0], i);
	    }
	    for (int i = 0; i < intervals.length; i++) {
	      Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i][1]);
	      if (entry != null) result[i] = entry.getValue();
	      else result[i] = -1;
	    }
	    return result;
	  }
}
