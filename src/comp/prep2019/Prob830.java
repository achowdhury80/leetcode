package comp.prep2019;
import java.util.*;
public class Prob830 {
	public List<List<Integer>> largeGroupPositions(String S) {
		List<List<Integer>> result = new ArrayList<>();
		char[] arr = S.toCharArray();
		int start = 0;
		char last = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != last) {
				if (i - start >= 3) result.add(Arrays.asList(start, i - 1));
				start = i;
				last = arr[i];
			}
		}
		if (arr.length - start >= 3) result.add(
				Arrays.asList(start, arr.length - 1));
		return result;
    }
}
