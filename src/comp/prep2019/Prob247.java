package comp.prep2019;
import java.util.*;
public class Prob247 {
	public List<String> findStrobogrammatic(int n) {
		List<String> result = new ArrayList<>();
		if(n < 1) return result;
		if (n % 2 == 1) {
			result.add("0");
			result.add("1");
			result.add("8");
		} else result.add("");
		int[] left = new int[] {0, 1, 6, 8, 9}, right = {0, 1, 9, 8, 6};
		for (int i = 0; i < (n / 2); i++) {
			List<String> temp = new ArrayList<>();
			for (int j = 0; j < left.length; j++) {
				if (j == 0 && i == (n / 2) - 1) continue;
				for (String s : result) {
					temp.add(left[j] + s + right[j]);
				}
			}
			result = temp;
		}
		return result;
    }
}
