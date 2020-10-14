package comp.prep2019;
import java.util.*;
public class Prob282 {
	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<>();
		helper(num, 0, 0, 1, target, "", result);
		return result;
    }
	
	public void helper(String num, int pos, long eval, long mult, int target,
			String path, List<String> result) {
		if (pos == num.length()) {
			if (eval == target) result.add(path);
			return;
 		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0') break;
			long cur = Long.valueOf(num.substring(pos, i + 1));
			if (pos == 0) helper(num, i + 1, cur, cur, target, "" + cur, result);
			else {
				helper(num, i + 1, eval + cur, cur, target, path + "+" + cur, 
						result);
				helper(num, i + 1, eval - cur, -cur, target, path + "-" + cur, 
						result);
				helper(num, i + 1, eval - mult + mult * cur, mult * cur, target, 
						path + "*" + cur, result);
			}
		}
	}
}
