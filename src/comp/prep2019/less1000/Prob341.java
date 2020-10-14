package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.NestedInteger;
public class Prob341 implements Iterator<Integer> {
	private Stack<NestedInteger> stack;
	public Prob341(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i > -1; i--) stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        while(!stack.isEmpty() && !stack.peek().isInteger()) {
        	List<NestedInteger> list = stack.pop().getList();
        	for (int i = list.size() - 1; i > -1; i--) stack.push(list.get(i));
        }
        return !stack.isEmpty();
    }
}
