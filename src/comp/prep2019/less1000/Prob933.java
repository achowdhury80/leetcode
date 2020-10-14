package comp.prep2019.less1000;
import java.util.*;
public class Prob933 {
	/**
	 * O(1) space and time here n is 3000
	 */
	private List<Integer> list;
	public Prob933() {
        list = new ArrayList<>();
    }
    public int ping(int t) {
        list.add(t);
        while(list.get(0) < t - 3000) list.remove(0);
        return list.size();
    }
}
