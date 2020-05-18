package comp.prep2019;
import java.util.*;
public class Prob491 {
	public List<List<Integer>> findSubsequences(int[] nums) {
	    TreeMap<Integer, Set<List<Integer>>> treeMap = new TreeMap<>();
	    for (int i = nums.length - 1; i > -1; i--) {
	      Map<Integer, Set<List<Integer>>> map = treeMap.subMap(nums[i], true, Integer.MAX_VALUE, true);
	      if (map.isEmpty()) {
	        List<Integer> list = new ArrayList<>();
	        list.add(nums[i]);
	        treeMap.put(nums[i], new HashSet<>());
	        treeMap.get(nums[i]).add(list);
	      } else {
	        Set<List<Integer>> set = new HashSet<>();
	        for (Map.Entry<Integer, Set<List<Integer>>> entry : map.entrySet()) {
	          set.addAll(entry.getValue());
	          for (List<Integer> list : entry.getValue()) {
	            List<Integer> newList = new ArrayList<>(list);
	            newList.add(0, nums[i]);
	            set.add(newList);
	          }
	        }
	        List<Integer> list = new ArrayList<>();
	        list.add(nums[i]);
	        set.add(list);
	        treeMap.put(nums[i], set);
	      }
	    }
	    Set<List<Integer>> result = new HashSet<>();

	    for (Set<List<Integer>> set : treeMap.values()) {
	      Set<List<Integer>> newSet = new HashSet<>();
	      for (List<Integer> list : set) {
	        if (list.size() > 1) newSet.add(list);
	      }
	      result.addAll(newSet);
	    }
	    return new ArrayList<>(result);
	  }
}
