package comp.prep2019;

public class Prob8 {
	public int myAtoi(String str) {
        char[] arr = str.toCharArray();
        int result = 0;
        boolean started = false;
        int sign = 1;
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i];
        	if (c == ' ') {
        		if (started) break;
        	} else if (c == '+' || c == '-') {
        		if (started) break;
        		started = true;
        		if (c == '-') sign = -1;
        	} else if (Character.isDigit(c)) {
        		started = true;
        		int newDigit = c - '0';
        		if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && newDigit > 7) {
        			if (sign > 0) return Integer.MAX_VALUE;
        			return Integer.MIN_VALUE;
        		}
        		result = result * 10 + newDigit;
        	} else break;
        }
        if (!started) return 0;
        return sign * result;
    }
	
	public static void main(String[] args) {
		Prob8 prob = new Prob8();
		//System.out.println(prob.myAtoi("2147483648"));
		System.out.println(prob.myAtoi("-91283472332"));
		
	}
}
