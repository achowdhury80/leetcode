package comp.prep2019;
import java.util.*;
public class Prob726 {
	public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
        	char c = formula.charAt(i);
        	if (c == '(') stack.push(new Pair(c));
        	else if (Character.isDigit(c)) {
        		stack.peek().appendCount(c);
        	} else if (Character.isLowerCase(c)) {
        		stack.peek().addToName(c);
        	} else if (Character.isUpperCase(c)) {
        		stack.push(new Pair(c));
        	} else if (c == ')') {
        		int repeat = 0;
        		while(i < formula.length() - 1 && Character.isDigit(formula.charAt(i + 1))) {
        			repeat = repeat * 10 + (formula.charAt(i + 1) - '0');
        			i++;
        		}
        		if (repeat == 0) repeat = 1;
        		Stack<Pair> temp = new Stack<>();
        		Pair pair;
        		while(!(pair = stack.pop()).name.equals("(")) {
        			if (pair.count == 0) pair.count = 1;
        			pair.count *= repeat;
        			temp.push(pair);
        		}
        		while(!temp.isEmpty()) stack.push(temp.pop());
        	}
        }
        while(!stack.isEmpty()) {
        	Pair pair = stack.pop();
        	if (pair.count == 0) pair.count = 1;
        	map.put(pair.name, map.getOrDefault(pair.name, 0) + pair.count);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (x, y) -> x.getKey().compareTo(y.getKey()));
        String result = "";
        for (Map.Entry<String, Integer> entry : list) 
        	result += entry.getKey() + (entry.getValue() == 1 ? "" : entry.getValue());
        return result;
    }
	
	class Pair {
		String name;
		int count = 0;
		Pair(char c) {
			this.name = "" + c;
		}
		
		void addToName(char c) {
			this.name = name + c;
		}
		
		void appendCount(char c) {
			count = count * 10 + (c - '0');
		}
	}
	
	public static void main(String[] args) {
		Prob726 prob = new Prob726();
		System.out.println(prob.countOfAtoms("H2O"));
	}
}
