package comp.prep2019;
import java.util.*;
public class Prob735 {
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
        	if (stack.isEmpty() || stack.peek() < 0 || i > 0) stack.push(i);
        	else {
        		while (!stack.isEmpty() && i < 0 && stack.peek() > 0 && stack.peek() < Math.abs(i)) {
        			stack.pop();
        		}
        		if (stack.isEmpty() || stack.peek() < 0) stack.push(i);
        		else if (stack.peek() == Math.abs(i)) stack.pop();
        	}
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i > -1; i--) result[i] = stack.pop();
        return result;
    }
}
