package comp.prep2019;
import java.util.*;
public class Prob384 {
	private int[] original;
	public Prob384(int[] nums) {
        this.original = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original.clone();
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	if(original == null || original.length < 2) return original; 
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < original.length; i++) list.add(i);
        Random random = new Random();
        int[] result = new int[original.length];
        for(int i = 0; i < original.length; i++){
          int nextIndex = random.nextInt(list.size());
          result[list.remove(nextIndex)] = original[i];
        }
        return result;
    }
}
