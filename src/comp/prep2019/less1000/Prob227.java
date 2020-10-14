package comp.prep2019.less1000;
import java.util.*;
public class Prob227 {
	public int calculate(String s) {
	    if(s == null || s.trim().length() == 0) return 0;
	    int val = 0;
	    char sign = '+';
	    Deque<Integer> dq = new ArrayDeque<>();
	    for (char c : s.toCharArray()) {
	    	if (c == '+' || c == '-' || c == '*' || c == '/') {
	    		func(sign, val, dq);
	    		val = 0;
	    		sign = c;
	    		
	    	} else if (c == ' ') continue;
	    	else {
	    		val = val * 10 + (c - '0');
	    	}
	    }
	    func(sign, val, dq);
	    int result = 0;
	    while(!dq.isEmpty()) result += dq.pollFirst();
	    return result;
	  }

	  private void func(char sign, int val, Deque<Integer> dq) {
		  switch (sign) {
	  		case '+':
	  			dq.offerLast(val);
	  			break;
	  	
	  		case '-': 
	  			dq.offer(-val);
	  			break;
	  		case '*':
	  			dq.offer(dq.pollLast() * val);
	  			break;
	  		case '/':
	  			dq.offer(dq.pollLast() / val);
	  			break;
		  }
	  }
	  
	  public static void main(String[] args) {
		  Prob227 prob = new Prob227();
		  System.out.println(prob.calculate("3+2*2"));
	  }
}
