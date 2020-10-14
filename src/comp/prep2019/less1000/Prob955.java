package comp.prep2019.less1000;
import java.util.*;
public class Prob955 {
	public int minDeletionSize(String[] A) {
		if(A.length < 2) return 0;
		int result = 0, n = A[0].length();
        boolean[] deleted = new boolean[n];
        boolean reStart = true;
        while(reStart) {
        	for (int i = 0; i < A.length - 1; i++) {
        		reStart = false;
        		for (int j = 0; j < A[0].length(); j++) {
        			if(deleted[j]) continue;
        			if (A[i].charAt(j) < A[i + 1].charAt(j)) break;
        			else if (A[i].charAt(j) > A[i + 1].charAt(j)) {
        				result++;
        				if(result == n) return result;
        				deleted[j] = true;
        				reStart = true;
        				break;
        			}
        		}
        		if (reStart) break;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob955 prob = new Prob955();
		System.out.println(prob.minDeletionSize(new String[] {"abx","agz","bgc","bfc"}));
		System.out.println(prob.minDeletionSize(new String[] {"vygiv","rchwt","fgxaj"}));
	}
}
