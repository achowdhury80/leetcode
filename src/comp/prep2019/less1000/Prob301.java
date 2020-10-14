package comp.prep2019.less1000;
import java.util.*;

public class Prob301 {
	public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
        boolean found = false;
        List<String> result = new ArrayList<>();
        while(!q.isEmpty() && !found) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		String st = q.poll();
        		if (isValid(st)) {
        			result.add(st);
        			visited.add(st);
        			found = true;
        		}
        		if (found) continue;
        		for (int j = 0; j < st.length(); j++) {
        			if (st.charAt(j) != '(' && st.charAt(j) != ')') 
        				continue;
        	        String newS = st.substring(0, j) 
        	        		+ st.substring(j + 1);
        	        if (!visited.contains(newS)) {
        	          q.offer(newS);
        	          visited.add(newS);
        	        }
        		}
        	}
        }
        return result;
    }
	
	private boolean isValid(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') count++;
			else if (c == ')') count--;
			if (count < 0) return false;
		}
		return count == 0;
	}
	
	public static void main(String[] args) {
		  Prob301 prob = new Prob301();
		  System.out.println(prob.removeInvalidParentheses(")("));
	  }
}
