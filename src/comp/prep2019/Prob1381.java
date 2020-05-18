package comp.prep2019;
import java.util.*;
public class Prob1381 {
	private List<Integer> list;
	private int max, count;
	public Prob1381(int maxSize) {
        list = new ArrayList<>();
        max = maxSize;
    }
    
    public void push(int x) {
        if (count == max) return;
        count++;
        list.add(x);
    }
    
    public int pop() {
        if (count == 0) return -1;
        int result = list.remove(count - 1);
        count--;
        return result;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(count, k); i++) {
        	list.set(i, list.get(i) + val);
        }
    }
}
