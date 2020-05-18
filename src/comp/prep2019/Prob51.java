package comp.prep2019;
import java.util.*;
public class Prob51 {
	//O(N!)
	public List<List<String>> solveNQueens(int n) {
		String s = "";
		for (int i = 0; i < n; i++) s += ".";
		List<List<String>> result = new ArrayList<>();
		helper(new ArrayList<>(), n, result, s);
		return result;
    }
	
	private void helper(List<String> current, int n, 
			List<List<String>> result, String emptyRow) {
		if (current.size() == n) {
			result.add(current);
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
	
	public static void main(String[] args) {
		Prob51 prob = new Prob51();
		System.out.println(prob.solveNQueens(4));
	}
}
