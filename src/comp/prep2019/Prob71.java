package comp.prep2019;
import java.util.*;
public class Prob71 {
	public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int start = 0;
        if (!path.endsWith("/")) path += "/";
        for (int i = 0; i < path.length(); i++) {
        	char c = path.charAt(i);
        	if (c == '/') {
	        	int j = i + 1;
	        	while(j < path.length() && path.charAt(j) == '/') j++;
	        	String prev = path.substring(start, i);
	        	if ("..".equals(prev)) {
	        		if (stack.size() > 1) stack.pop();
	        	} else if (!".".equals(prev)) {
	        		stack.push(path.substring(start, i));
	        	}
	        	i = j - 1;
	        	start = i + 1;
        	}
        }
        String result = stack.pop();
        while(!stack.isEmpty()) {
        	result = stack.pop() + "/" + result;
        }
        return result.length() == 0 ? "/" : result;
    }
	
	public static void main(String[] args) {
		Prob71 prob = new Prob71();
		System.out.println(prob.simplifyPath("/a//b////c/d//././/.."));
	}
}
