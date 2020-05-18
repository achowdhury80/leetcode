package comp.prep2019;
import java.util.*;
public class Prob528 {
	private TreeMap<Integer, Integer> treeMap;
	private Random random;
	private int sum;
	public Prob528(int[] w) {
		treeMap = new TreeMap<>();
		random = new Random();
		sum = 0;
		for (int i = 0; i < w.length; i++) {
			sum += w[i];
			treeMap.put(sum, i);
		}
    }
    
    public int pickIndex() {
        int val = random.nextInt(sum) + 1;
        return treeMap.ceilingEntry(val).getValue();
    }
}
