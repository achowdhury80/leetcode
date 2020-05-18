package comp.prep2019;
import java.util.*;
public class Prob739 {
	public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i > -1; i--) {
        	while (!stack.isEmpty() && T[stack.peek()] <= T[i]) stack.pop();
        	if (!stack.isEmpty()) result[i] = stack.peek() - i;
        	stack.push(i);
        }
        return result;
    }
}
