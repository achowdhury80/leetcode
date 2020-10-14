package comp.prep2019.less1000;
import java.util.*;
public class Prob986 {
	/**
	 * O(M + N) time 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < A.length && j < B.length) {
        	int[] a = A[i];
        	int[] b = B[j];
        	if (a[1] < b[0]) i++;
        	else if (b[1] < a[0]) j++;
        	else {
        		if (a[1] < b[1]) {
        			list.add(new int[] {Math.max(a[0], b[0]), a[1]});
        			i++;
        		} else if (a[1] > b[1]) {
        			list.add(new int[] {Math.max(a[0], b[0]), b[1]});
        			j++;
        		} else {
        			list.add(new int[] {Math.max(a[0], b[0]), a[1]});
        			i++;
        			j++;
        		}
        	}
        }
        int[][] result = new int[list.size()][];
        for (int k = 0; k < list.size(); k++) result[k] = list.get(k);
        return result;
    }
}
