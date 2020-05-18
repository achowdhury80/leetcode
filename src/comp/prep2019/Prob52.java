package comp.prep2019;

import java.util.ArrayList;
import java.util.List;

public class Prob52 {
	//O(N!)
	public int totalNQueens(int n) {
		String s = "";
		for (int i = 0; i < n; i++) s += ".";
		int[] result = new int[] {0};
		helper(new ArrayList<>(), n, result, s);
		return result[0];
    }
	
	private void helper(List<String> current, int n, 
			int[] result, String emptyRow) {
		if (current.size() == n) {
			result[0]++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (canBePalced(current, n, i)) {
				String newRow = emptyRow.substring(0, i) + "Q" + emptyRow.substring(i + 1);
				List<String> newList = new ArrayList<>(current);
				newList.add(newRow);
				helper(newList, n, result, emptyRow);
			}
		}
	}

	private boolean canBePalced(List<String> current, int n, int idx) {
		if (current.size() == 0) return true;
		for (int i = 0; i < current.size(); i++) {
			int rowDiff = current.size() - i;
			if (current.get(i).charAt(idx) == 'Q') return false;
			if (idx - rowDiff > -1 && current.get(i).charAt(idx - rowDiff) == 'Q') 
				return false;
			if (idx + rowDiff < n && current.get(i).charAt(idx + rowDiff) == 'Q') 
				return false;
		}
		return true;
	}
}
