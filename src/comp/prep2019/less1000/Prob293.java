package comp.prep2019.less1000;
import java.util.*;
public class Prob293 {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> result = new ArrayList<>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == '+' && arr[i + 1] == '+') {
				arr[i] = '-';
				arr[i + 1] = '-';
				result.add(new String(arr));
				arr[i] = '+';
				arr[i + 1] = '+';
			}
		}
		return result;
    }
}
