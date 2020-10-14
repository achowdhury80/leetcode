package comp.prep2019.less1000;
import java.util.*;
public class Prob352 {
	private TreeSet<int[]> treeSet;
	public Prob352() {
        treeSet = new TreeSet<>((x, y) -> x[0] - y[0]);
    }
    
    public void addNum(int val) {
    	int[] newRange = new int[] {val, val};
        int[] pre = treeSet.floor(newRange);
        if (pre != null && pre[1] + 1 >= val) {
        	treeSet.remove(pre);
        	newRange = new int[] {Math.min(pre[0], newRange[0]), 
        			Math.max(pre[1], newRange[1])};
        }
        int[] next = treeSet.ceiling(newRange);
        if (next != null && newRange[1] + 1 >= next[0]) {
        	treeSet.remove(next);
        	newRange = new int[] {Math.min(next[0], newRange[0]), 
        			Math.max(next[1], newRange[1])};
        }
        treeSet.add(newRange);
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[treeSet.size()][];
        int i = 0;
        for (int[] range : treeSet) result[i++] = new int[] {range[0], range[1]};
        return result;
    }
}
