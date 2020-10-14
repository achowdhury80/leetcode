package comp.prep2019.less1000;
import java.util.*;
public class Prob842 {
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> result = new ArrayList<>();
		int n = S.length();
		if (n < 3) return result;
		for (int i = 1; i < (n + 1) / 2; i++) {
			if (i > 1 && S.charAt(0) == '0') break;
			long first = Long.parseLong(S.substring(0, i));
			if (first >= Integer.MAX_VALUE) break;
			for (int j = 1; Math.max(i, j) <= (n - i - j); j++) {
				if (j > 1 && S.charAt(i) == '0') break;
				long second = Long.parseLong(S.substring(i, i + j));
				if (second >= Integer.MAX_VALUE) break;
				isFibo(S, i + j, (int)first, (int)second, result);
				if (result.size() > 1) return result;
			}
		}
		return result;
    }
	
	private void isFibo(String S, int startIdx, int first, int second, List<Integer> result) {
		long next = 0l + first + second;
		if (next >= Integer.MAX_VALUE) return;
		String nextStr = next + "";
		for (int i = 0; i < nextStr.length(); i++) {
			if (startIdx + i == S.length() || S.charAt(startIdx + i) != nextStr.charAt(i)) return;
		}
		if (startIdx + nextStr.length() == S.length()) {
			result.add(first);
			result.add(second);
			result.add((int)next);
		} else {
			isFibo(S, startIdx + nextStr.length(), second, (int)next, result);
			if (result.size() == 0) return;
			result.add(0, first);
		}
	}
}
