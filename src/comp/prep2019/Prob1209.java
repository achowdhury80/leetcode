package comp.prep2019;
import java.util.*;
public class Prob1209 {
	public String removeDuplicates(String s, int k) {
        char[] arr = s.toCharArray();
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
        	int ch = arr[i] - 'a';
        	if (!stack.isEmpty() && stack.peek()[0] == ch) {
        		int[] val = stack.pop();
        		val[1]++;
        		val[1] %= k;
        		if (val[1] != 0) stack.push(new int[] {ch, val[1]});
        	} else {
        		stack.push(new int[] {ch, 1});
        	}
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
        	int[] val = stack.pop();
        	for (int i = 0; i < val[1]; i++) sb.insert(0, (char)(val[0] + 'a'));
        }
        return sb.toString();
    }
}
