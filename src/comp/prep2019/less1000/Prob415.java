package comp.prep2019.less1000;

public class Prob415 {
	public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        String result = "";
        while(i > -1 || j > -1 || carry > 0) {
        	if (i > -1) {
        		carry += num1.charAt(i) - '0';
        		i--;
        	}
        	if (j > -1) {
        		carry += num2.charAt(j) - '0';
        		j--;
        	}
        	result = (carry % 10) + result;
        	carry /= 10;
        }
        return result;
    }
}
