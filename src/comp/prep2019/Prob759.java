package comp.prep2019;
import java.util.*;
public class Prob759 {
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> all = new ArrayList<>();
        for (List<Interval> list : schedule) {
        	for (Interval intv : list) {
        		all.add(intv);
        	}
        }
        Collections.sort(all, (x, y) -> x.end == y.end ? x.start - y.start : x.end - y.end);
        List<Interval> temp = new ArrayList<>();
        Interval cur = all.get(0); 
        for (int i = 1; i < all.size(); i++) {
        	Interval next = all.get(i);
        	if (next.start > cur.end) {
        		temp.add(cur);
        		cur = next;
        	} else {
        		cur = new Interval(Math.min(cur.start, next.start), next.end);
        	}
        }
        temp.add(cur);
        all = temp;
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < all.size() - 1; i++) {
        	result.add(new Interval(all.get(i).end, all.get(i + 1).start));
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
}	
