package comp.prep2019.less1000;

public class Prob8 {
	public int myAtoi(String str) {
		if ("".equals(str)) return 0;
		boolean started = false, signRetrieved = false;
		int sign = 1;
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (signRetrieved && (c == '+' || c == '-')) break;
			if (!started && c != ' ' && c != '+' && c != '-'
					&& !Character.isDigit(c)) return 0;
			if (started && !Character.isDigit(c)) break;
			if (c == '+' || c == '-') {
				signRetrieved = true;
                started = true;
				if (c == '-') sign = -1;
				continue;
			}
			if (Character.isDigit(c)) {
				if (!started) {
					result = sign * (result + (c - '0'));
					started = true;
					continue;	
				} 
				int temp = result * 10 + sign * (c - '0');
				if (temp / 10 != result) 
					return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				result = temp;
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		Prob8 prob = new Prob8();
		//System.out.println(prob.myAtoi("42"));
		System.out.println(prob.myAtoi("2147483648"));
		//System.out.println(prob.myAtoi("-91283472332"));
		
	}
}
