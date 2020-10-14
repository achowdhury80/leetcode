package comp.prep2019.less1000;

public class Prob67 {
	public String addBinary(String a, String b) {
        String result = "";
        int carry = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
        	int a1 = i < a.length() ? a.charAt(a.length() - i - 1) - '0' : 0;
        	int b1 = i < b.length() ? b.charAt(b.length() - i - 1) - '0' : 0;
        	result = (carry ^ a1 ^ b1) + result;
        	carry = (carry + a1 + b1) / 2;
        }
        if (carry > 0) result = 1 + result;
        return result;
    }
}
