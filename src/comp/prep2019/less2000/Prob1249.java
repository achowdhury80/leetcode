package comp.prep2019.less2000;
import java.util.*;
public class Prob1249 {
	public String minRemoveToMakeValid(String s) {
        Set<Integer> removeIndex = new HashSet<>();
        Stack<Integer> leftIndex = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == ')') {
        		if (!leftIndex.isEmpty()) leftIndex.pop();
        		else removeIndex.add(i);
        	} else if (arr[i] == '(') leftIndex.push(i);
        }
        while(!leftIndex.isEmpty()) removeIndex.add(leftIndex.pop());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
        	if (!removeIndex.contains(i)) result.append(arr[i]);
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		Prob1249 prob = new Prob1249();
		System.out.println(prob.minRemoveToMakeValid("lee(t(c)o)de)"));
	}
}
