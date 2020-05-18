package comp.prep2019;
import java.util.*;
public class Prob346 {
	private List<Integer> list;
	private int size, sum;
	/** Initialize your data structure here. */
    public Prob346(int size) {
        this.size = size;
        list = new ArrayList<>();
        sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        list.add(val);
        if (list.size() > size) {
        	sum -= list.remove(0);
        }
        return (sum + 0.0)/ list.size();
    }
}
