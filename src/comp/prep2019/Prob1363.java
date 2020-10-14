package comp.prep2019;

import java.util.Arrays;
import java.util.*;
public class Prob1363 {
	public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        int sum = 0;
        int[] ones = new int[] {0, 0}, twos = new int[] {0, 0};
        for (int i : digits) {
        	sum += i;
        	if (ones[1] == 0 && i % 3 == 1) {
        		if (ones[0] == 0) ones[0] = i;
        		else ones[1] = i;
        	}
        	if (twos[1] == 0 && i % 3 == 2) {
        		if (twos[0] == 0) twos[0] = i;
        		else twos[1] = i;
        	}
        }
        List<Integer> toBeRemoved = new ArrayList<>();
        if (sum % 3 == 1) {
        	if (ones[0] != 0) toBeRemoved.add(ones[0]);
        	else if (twos[1] != 0) {
        		toBeRemoved.add(twos[0]);
        		toBeRemoved.add(twos[1]);
        	}
        } else if (sum % 3 == 2) {
        	if (twos[0] != 0) toBeRemoved.add(twos[0]);
        	else if (ones[1] != 0) {
        		toBeRemoved.add(ones[0]);
        		toBeRemoved.add(ones[1]);
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = digits.length - 1; i > -1; i--) {
        	if (!toBeRemoved.isEmpty() && digits[i] 
        			== toBeRemoved.get(toBeRemoved.size() - 1)) {
        		toBeRemoved.remove(toBeRemoved.size() - 1);
        	} else {
        		sb.append(digits[i]);
        	}
        }
        if (sb.length() == 0) return "";
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
