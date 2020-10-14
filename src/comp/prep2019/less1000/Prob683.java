package comp.prep2019.less1000;
import java.util.*;
public class Prob683 {
	public int kEmptySlots(int[] bulbs, int K) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
        	Integer temp = treeSet.lower(bulbs[i]);
        	if (temp != null && bulbs[i] - temp == K + 1) return i + 1;
        	temp = treeSet.higher(bulbs[i]);
        	if (temp != null && temp - temp == K + 1) return i + 1;
        	treeSet.add(bulbs[i]);
        }
        return -1;
    }
}
