package comp.prep2019.less2000;
import java.util.*;
public class Prob1253 {
	public List<List<Integer>> reconstructMatrix(int upper, int lower, 
			int[] colsum) {
		List<List<Integer>> result = new ArrayList<>();
		int sum = 0;
		int bothOne = 0;
		for (int i = 0; i < colsum.length; i++) {
			sum += colsum[i];
			if (colsum[i] == 2) bothOne++;
		}
		if (sum != upper + lower || upper < bothOne || lower < bothOne) 
			return result;
		List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
		result.add(l1);
		result.add(l2);
		for (int i = 0; i < colsum.length; i++) {
			if (colsum[i] == 0) {
				l1.add(0);
				l2.add(0);
			} else if (colsum[i] == 2) {
				l1.add(1);
				l2.add(1);
				upper--;
				lower--;
			} else {
				if (upper >= lower) {
					l1.add(1);
					l2.add(0);
					upper--;
				} else {
					l1.add(0);
					l2.add(1);
					lower--;
				}
			}
		}
		return result;
    }
}
