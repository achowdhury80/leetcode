package comp.prep2019;
import java.util.*;
public class Prob1424 {
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int count = 0;
        int start = -1;
        for (int i = 0; i < nums.size(); i++) {
        	start++;
        	for (int j = 0; j < nums.get(i).size(); j++) {
        		if (lists.size() <= j + start) lists.add(new ArrayList<>());
        		lists.get(start + j).add(0, nums.get(i).get(j));
        		count++;
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
