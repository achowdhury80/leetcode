package comp.prep2019;
import java.util.*;
public class Prob1431 {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for (int candy : candies) {
        	max = Math.max(max, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
        	result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}
