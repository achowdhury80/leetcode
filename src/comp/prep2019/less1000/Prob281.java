package comp.prep2019.less1000;
import java.util.*;
public class Prob281 {
	private Queue<Iterator<Integer>> q;
	public Prob281(List<Integer> v1, List<Integer> v2) {
        this.q = new LinkedList<>();
        q.offer(v1.iterator());
        q.offer(v2.iterator());
    }

    public int next() {
    	Iterator<Integer> itr = q.poll();
    	int result = itr.next();
    	q.offer(itr);
    	return result;
    }

    public boolean hasNext() {
        while(!q.isEmpty() && !q.peek().hasNext()) {
        	q.poll();
        }
        return !q.isEmpty();
    }
}
