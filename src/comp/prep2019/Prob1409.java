package comp.prep2019;
import java.util.*;
public class Prob1409 {
	/**
	 * O(NM) time
	 * @param queries
	 * @param m
	 * @return
	 */
	 public int[] processQueries(int[] queries, int m) {
		 List<Integer> list = new ArrayList<>();
		 for (int i = 1; i <= m; i++) list.add(i);
		 int[] result = new int[queries.length];
		 for (int i=0; i < queries.length; i++) {
			 int q = queries[i];
			 int idx = list.indexOf(q);
			 result[i] = idx;
			 list.remove(idx);
			 list.add(0, q);
			 
		 }
		 return result;
	 }
}
