package comp.prep2019;

public class Prob1006 {
	public int clumsy(int N) {
		int result = N--;
		if (N == 0) return result;
		result *= N--;
		if(N == 0) return result;
		result /= N--;
		if (N == 0) return result;
        for (int i = N; i > 0; i--) {
        	result += i--;
        	if (i == 0) break;
        	int val = i--;
        	if (i == 0) {
        		result -= val;
        		break;
        	}
        	val *= i--;
        	if (i == 0) {
        		result -= val;
        		break;
        	}
        	val /= i;
        	result -= val;
        }
        return result;
    }
}
