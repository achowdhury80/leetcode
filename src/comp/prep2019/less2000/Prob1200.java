package comp.prep2019.less2000;
import java.util.*;
public class Prob1200 {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>(); 
        int cur = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
        	int diff = arr[i] - arr[i - 1];
        	if (diff <= cur) {
        		List<Integer> list = new ArrayList<>();
        		list.add(arr[i - 1]);
        		list.add(arr[i]);
        		if (diff < cur) result.clear();
        		result.add(list);
        		cur = diff;
        	} 
        	
        }
        return result;
    }
}
