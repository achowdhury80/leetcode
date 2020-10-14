package comp.prep2019.less1000;
import java.util.*;
public class Prob57 {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> list = new ArrayList<>();
		for (int[] interval : intervals) {
			list.add(interval);
		}
		list.add(0, newInterval);
		int count = list.size();
        for (int i = 0; i < list.size() - 1; i++) {
        	if (list.get(i + 1)[0] > list.get(i)[1]) break;
        	else if (list.get(i)[0] > list.get(i + 1)[1]) {
        		int[] temp = list.get(i);
        		list.set(i, list.get(i + 1));
        		list.set(i + 1, temp);
        	} else {
        		int[] intv = new int[] {Math.min(list.get(i)[0], list.get(i + 1)[0]), Math.max(list.get(i)[1], list.get(i + 1)[1])};
        		count--;
        		list.remove(i);
        		list.set(i, intv);
        		i--;
        	}
        }
        int[][] result = new int[count][];
        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
	
	public static void main(String[] args) {
		Prob57 prob = new Prob57();
		int[][] result = prob.insert(new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},  new int[] {4, 8});
		for (int[] arr : result) {
			System.out.print("[" + arr[0] + ", " + arr[1] + "], ");
		}
	}
}
