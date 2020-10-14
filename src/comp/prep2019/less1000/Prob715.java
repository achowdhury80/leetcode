package comp.prep2019.less1000;
import java.util.*;
public class Prob715 {
	private TreeSet<Interval> treeSet;
	public Prob715() {
		treeSet = new TreeSet<>();
    }
    
    public void addRange(int left, int right) {
    	Iterator<Interval> itr = treeSet.tailSet(new Interval(0, left - 1))
    			.iterator();
    	while(itr.hasNext()) {
    		Interval interval = itr.next();
    		if (right < interval.left) break;
    		left = Math.min(left, interval.left);
    		right = Math.max(right, interval.right);
    		itr.remove();
    	}
    	treeSet.add(new Interval(left, right));
    }
    
    public boolean queryRange(int left, int right) {
        Interval iv = treeSet.higher(new Interval(0, left));
        return iv != null && iv.left <= left && iv.right >= right;
    }
    
    public void removeRange(int left, int right) {
    	Iterator<Interval> itr = treeSet.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> todo = new ArrayList<>();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left) break;
            if (iv.left < left) todo.add(new Interval(iv.left, left));
            if (right < iv.right) todo.add(new Interval(right, iv.right));
            itr.remove();
        }
        for (Interval iv: todo) treeSet.add(iv);
    }
    
    class Interval implements Comparable<Interval> {
    	int left, right;
    	Interval(int left, int right) {
    		this.left = left;
    		this.right = right;
    	}
		@Override
		public int compareTo(Interval that) {
			return this.right == that.right ? this.left - that.left 
					: this.right - that.right;
		}
    	
    }
}
