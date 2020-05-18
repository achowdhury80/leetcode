package comp.prep2019;
import java.util.*;
public class Prob1276 {
	public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		int a = (tomatoSlices - 2 * cheeseSlices);
		List<Integer> result = new ArrayList<>();
		if (a < 0 || a % 2 == 1) return result;
		int j = a / 2;
		int s = cheeseSlices - j;
		if (s < 0) return result;
		result.add(j);
		result.add(s);
		return result;
    }
}
