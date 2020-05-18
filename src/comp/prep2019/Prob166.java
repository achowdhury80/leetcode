package comp.prep2019;
import java.util.*;
public class Prob166 {
	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) return "0";
		Map<Long, Integer> map = new HashMap<>();
        String result = "";
        boolean sign = !((numerator >= 0) ^ (denominator >= 0));
        if (!sign) result += "-";
        long numer = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        result += numer / denom;
        numer = numer % denom;
        if (numer > 0) result += ".";
        while(numer > 0) {
        	if (map.containsKey(numer)) {
        		int index = map.get(numer);
        		return result.substring(0, index) + "(" + result.substring(index) 
        		+ ")";
        	}
        	map.put(numer, result.length());
        	numer *= 10;
        	result += numer / denom;
        	numer = numer % denom;
        }
        return result;
    }
}
