package comp.prep2019.less2000;
import java.util.*;
public class Prob1131 {
	public int maxAbsValExpr(int[] arr1, int[] arr2) {
		List<Integer> 
			sum1 = new ArrayList<>(),
			sum2 = new ArrayList<>(),
			diff1 = new ArrayList<>(),
			diff2 = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			sum1.add(arr1[i] + arr2[i] + i);
			sum2.add(arr1[i] + arr2[i] - i);
			diff1.add(arr1[i] - arr2[i] + i);
			diff2.add(arr1[i] - arr2[i] - i);
		}
		return Math.max(Math.max(findMaxDiff(sum1), findMaxDiff(sum2)), 
				Math.max(findMaxDiff(diff1), findMaxDiff(diff2)));
    }
	
	private int findMaxDiff(List<Integer> list) {
		int min = list.get(0), max = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			min = Math.min(min, list.get(i));
			max = Math.max(max, list.get(i));
		}
		return max - min;
	}
}
