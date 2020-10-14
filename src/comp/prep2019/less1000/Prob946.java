package comp.prep2019.less1000;
import java.util.*;
public class Prob946 {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped.length >  pushed.length) return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while(j < popped.length) {
        	if (!stack.isEmpty() && stack.peek() == popped[j]) {
        		stack.pop();
        		j++;
        	} else if (i == pushed.length) return false;
        	else stack.push(pushed[i++]);
        }
        return true;
    }
}
