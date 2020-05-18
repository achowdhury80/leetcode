package comp.prep2019;
import java.util.*;
public class Prob1346 {
	public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
        	if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2))) 
        		return true;
        	set.add(i);
        }
        return false;
    }
}
