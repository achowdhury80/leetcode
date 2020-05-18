package comp.prep2019;
import java.util.*;
public class Prob1424 {
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.get(0).size(); i++) {
        	lists.add(new ArrayList<>());
        	lists.get(i).add(nums.get(0).get(i));
            count++;
        }
        for (int i = 1; i < nums.size(); i++) {
        	for (int j = 0; j < nums.get(i).size(); j++) {
        		count++;
        		if (lists.size() <= j + i) lists.add(new ArrayList<>());
        		lists.get(j + i).add(0, nums.get(i).get(j));
        	}
        }
        int[] result = new int[count];
        int idx = 0;
        for (int i = 0; i < lists.size(); i++) {
        	for (int j = 0; j < lists.get(i).size(); j++) {
        		result[idx++] = lists.get(i).get(j);
        	}
        }
        return result;
    }
}
