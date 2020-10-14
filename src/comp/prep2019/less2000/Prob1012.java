package comp.prep2019.less2000;
import java.util.*;
public class Prob1012 {
	public int numDupDigitsAtMostN(int N) {
        if (N < 11) return 0;
        int count = 9;
        long val = 100;
        
        for (int i = 2; val - 1 <= N; val *= 10) {
        	int option = 10, prod = 1;
        	for (int j = 0 ; j < 2; j++) {
        		prod *= (option - (j == 0 ? 1 : 0));
        		option--;
        	}
        	count += prod;
        }
        val /= 10;
        if (val <= N) {
        	count += findCountWithoutRepeatation((int)val, N);
        }
        return N - count;
    }
	
	private int findCountWithoutRepeatation(int start, int end) {
		return 0;
	}
	
	private int findCountWithoutRepeatation(int start, int end, Set<Integer> blacklisted) {
		if (start == end) {
			if (isValid(start, blacklisted)) return 1;
			return 0;
		}
		return 0;
	}
	
	private boolean isValid(int num, Set<Integer> blacklisted) {
		Set<Integer> temp = new HashSet<>(blacklisted);
		while(num > 0) {
			if (temp.contains(num % 10)) return false;
			temp.add(num % 10);
			num /= 10;
		}
		return true;
	}
}
