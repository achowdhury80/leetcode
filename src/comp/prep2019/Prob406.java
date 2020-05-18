package comp.prep2019;

import java.util.*;

public class Prob406 {
	public int[][] reconstructQueue(int[][] people) {
		if(people == null || people.length < 2) return people;
		Arrays.sort(people, (int[]x, int[]y) -> {
		      if (y[0] == x[0]) return x[1] - y[1];
		      return y[0] - x[0];
		    });
		List<int[]> list = new ArrayList<>();
		for (int[] p : people) {
			if (list.isEmpty() || list.size() <= p[1]) list.add(p);
			else {
				list.add(p[1], p);
			}
		}
		int[][] result = new int[people.length][2];
		for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
		return result;
    }
}
