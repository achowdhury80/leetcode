package comp.prep2019.less1000;

import java.util.*;

public class Prob406 {
	/**
	 * O(NlogN)
	 * @param people
	 * @return
	 */
	public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
        	if (p[1] < list.size()) list.add(p[1], p);
        	else list.add(p);
        }
        int[][] result = new int[people.length][2];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
