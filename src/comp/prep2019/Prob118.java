package comp.prep2019;
import java.util.*;
public class Prob118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>(numRows);
		List<Integer> prev = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> newList = new ArrayList<>();
			newList.add(1);
			for (int j = 0; j < prev.size(); j++) {
				if (j == prev.size() - 1) newList.add(1);
				else newList.add(prev.get(j) + prev.get(j + 1));
			}
			result.add(newList);
			prev = newList;
		}
		return result;
    }
}
