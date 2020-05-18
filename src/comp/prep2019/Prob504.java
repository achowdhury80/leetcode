package comp.prep2019;

public class Prob504 {
	public String convertToBase7(int num) {
        String result = "";
        String sign = "";
        if(num < 0) {
        	sign = "-";
        	num *= -1;
        }
        while(num > 0) {
        	result = (num % 7) + result;
        	num /= 7;
        }
        return "".equals(result) ? "0" : (sign + result);
    }
}
