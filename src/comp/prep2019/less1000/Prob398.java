package comp.prep2019.less1000;
import java.util.*;
public class Prob398 {
	private Map<Integer, List<Integer>> map;
	public Prob398(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
        	list.add(i);
        	map.put(nums[i], list);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
