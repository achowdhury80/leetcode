package comp.prep2019;
import java.util.*;
public class Prob1291 {
	public List<Integer> sequentialDigits(int low, int high) {
		if(high < 12) return new ArrayList<>();
        int start = 12;
        int lastDigit = 3;
        while(start * 10 + lastDigit <= low) {
        	start = start * 10 + lastDigit;
        	lastDigit++;
        }
        List<Integer> result = new ArrayList<>();
        while (start < high) {
        	int cur = start;
        	int curDigit = cur % 10;
        	while(cur <= high && curDigit < 10) {
        		if (cur >= low && cur <= high) result.add(cur);
        		cur = Integer.parseInt(("" + cur).substring(1)) * 10 + (++curDigit);
        	}
        	start = start * 10 + lastDigit;
        	lastDigit++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1291 prob = new Prob1291();
		System.out.println(prob.sequentialDigits(10,1000000000));
	}
}
