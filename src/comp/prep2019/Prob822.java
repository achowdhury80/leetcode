package comp.prep2019;
import java.util.*;
public class Prob822 {
	
	public int flipgame(int[] fronts, int[] backs) {
		Set<Integer> notPossible = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
        	if (fronts[i] == backs[i]) notPossible.add(fronts[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
        	if (!notPossible.contains(fronts[i])) min = Math.min(min, fronts[i]);
        	if (!notPossible.contains(backs[i])) min = Math.min(min, backs[i]);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}	
