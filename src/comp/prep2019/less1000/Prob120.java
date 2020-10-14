package comp.prep2019.less1000;
import java.util.*;
public class Prob120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n;
        if ((n = triangle.size()) == 0) return 0;
        for (int i = n - 2; i > -1; i--) {
        	List<Integer> list = triangle.get(i);
        	List<Integer> next = triangle.get(i + 1);
        	for (int j = 0; j < list.size(); j++) {
        		list.set(j, list.get(j) + Math.min(next.get(j), next.get(j + 1)));
        	}
        }
        return triangle.get(0).get(0);
    }
}
