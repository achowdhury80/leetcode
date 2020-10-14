package comp.prep2019.less1000;

public class Prob405 {
	public String toHex(int num) {
		if (num == 0) return "0";
		String result = "";
        while(num != 0) {
        	int part = num & 15;
        	if (part < 10) result = part + result;
        	else {
        		result = ((char)((part - 10) + 'a')) + result;
        	}
        	num >>= 4;
        }
        return result;
    }	
}
