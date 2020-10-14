package comp.prep2019.less2000;
import java.util.*;
public class Prob1301 {
	public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size(), m = board.get(0).length();
        return helper(board, n, new int[] {n - 1, m - 1}, new HashMap<>());
    }
	
	private int[] helper(List<String> board, int n, int[] cur, 
			Map<Integer, int[]> map) {
		char c;
		if (cur[0] < 0 || cur[1] < 0 || (c = board.get(cur[0]).charAt(cur[1])) == 'X')
			return new int[] {0, 0};
		int idx = cur[0] * n + cur[1];
		if (map.containsKey(idx)) {
			int[] a = map.get(idx);
			return new int[] {a[0], a[1]};
		}
		if (cur[0] == 0 && cur[1] == 0) {
			map.put(idx, new int[] {0, 1});
			int[] a = map.get(idx);
			return new int[] {a[0], a[1]};
		}
		int[] left = new int[] {cur[0], cur[1] - 1}, 
				up = new int[] {cur[0] - 1, cur[1]},
				diag = new int[] {cur[0] - 1, cur[1] - 1};
		int[] result = helper(board, n, left, map);
		int[] upResult = helper(board, n, up, map);
		if (result[1] == 0 || result[0] < upResult[0]) result = upResult;
		else if (result[0] == upResult[0] && result[1] != 0) 
			result[1] = (int)((0l + result[1] + upResult[1]) % (long)(1e9 + 7));
		if (result[1] == 0) {
			result = helper(board, n, diag, map);
		}
		if (result[1] != 0) result[0] += (c == 'S' ? 0 : c - '0');
		map.put(idx, result);
		int[] a = map.get(idx);
		return new int[] {a[0], a[1]};
	}
	
	public static void main(String[] args) {
		Prob1301 prob = new Prob1301();
		int[] arr = prob.pathsWithMaxScore(Arrays.asList("E23","2X2","12S"));
		for (int i : arr) System.out.print(i + ", ");
	}
}
