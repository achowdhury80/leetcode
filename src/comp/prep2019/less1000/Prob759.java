package comp.prep2019.less1000;
import java.util.*;
public class Prob759 {
	/**
	 * O(NlogN)
	 * @param schedule
	 * @return
	 */
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<int[]> list = new ArrayList<>();
		for (List<Interval> emp : schedule) {
			for (Interval intv : emp) {
				list.add(new int[] {intv.start, 0});
				list.add(new int[] {intv.end, 1});
			}
		}
		Collections.sort(list, 
				(x, y) -> (x[0] == y[0] ? (y[1] - x[1]) : (x[0] - y[0])));
		int count = 0, prev = -1;
		List<Interval> result = new ArrayList<>();
		for (int i = 0; i < list.size() - 1; i++) {
			int[] elem = list.get(i);
			if (count == 0 && prev > -1) result.add(new Interval(prev, elem[0]));
			count += elem[1] == 0 ? 1 : -1;
			prev = elem[0];
		}
		return result;
	}
	
	class Interval {
	    public int start;
	    public int end;

	    public Interval() {}

	    public Interval(int _start, int _end) {
	        start = _start;
	        end = _end;
	    }
	}
	
	/*
	 * public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
       List<List<int[]>> brokenIntervals = new ArrayList<>();
       int i = 0;
       for (List<Interval> list : schedule) {
    	   brokenIntervals.add(new ArrayList<>());
    	   for (Interval intv : list) {
    		   brokenIntervals.get(i).add(new int[] {intv.start, 0});
    		   brokenIntervals.get(i).add(new int[] {intv.end, 1});
    	   }
    	   i++;
       }
       Queue<int[]> q = new PriorityQueue<>((x, y) -> 
       	brokenIntervals.get(x[0]).get(x[1])[0] 
       			== brokenIntervals.get(y[0]).get(y[1])[0] ?
       			brokenIntervals.get(y[0]).get(y[1])[1]
       			- brokenIntervals.get(x[0]).get(x[1])[1] 
       			: brokenIntervals.get(x[0]).get(x[1])[0] 
       			- brokenIntervals.get(y[0]).get(y[1])[0]);
       for (i = 0; i < brokenIntervals.size(); i++) {
    	   q.offer(new int[] {i, 0});
       }
       List<Interval> result = new ArrayList<>();
       int[] cur = q.peek();
       int open = 0, last = brokenIntervals.get(cur[0]).get(cur[1])[0];
       while(!q.isEmpty()) {
    	   cur = q.poll();
    	   int[] elem = brokenIntervals.get(cur[0]).get(cur[1]);
    	   if (open == 0 && last < elem[0]) result.add(new Interval(last, elem[0]));
    	   if (elem[1] == 0) open++;
    	   else open--;
           cur[1]++;
    	   if (cur[1] < brokenIntervals.get(cur[0]).size()) q.offer(cur);
           last = elem[0];
       }
       return result;
    }
	 */
}	
