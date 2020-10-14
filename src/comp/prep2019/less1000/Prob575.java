package comp.prep2019.less1000;
import java.util.*;
public class Prob575 {
	public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) set.add(i);
        return Math.min(candies.length / 2, set.size());
    }
}
