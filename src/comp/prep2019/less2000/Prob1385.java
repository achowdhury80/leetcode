package comp.prep2019.less2000;
import java.util.*;
public class Prob1385 {
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : arr2) treeSet.add(i);
        int result = 0;
        for (int i : arr1) {
        	int lowest = i - d, highest = i + d;
        	Integer val = treeSet.ceiling(lowest);
        	if (val == null || val > highest) result++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1385 prob = new Prob1385();
		System.out.println(prob.findTheDistanceValue(new int[] {4, 5, 8}, 
				new int[] {10, 9, 1,8}, 2));
	}
}
