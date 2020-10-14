package comp.prep2019.less1000;

public class Prob396 {
	public int maxRotateFunction(int[] A) {
        int n = A.length;
        int sum = 0, fVal = 0;
        for (int i = 0; i < n; i++) {
        	sum += A[i];
        	fVal += i * A[i];
        }
        int result = fVal;
        for (int i = n - 1; i > 0; i--) {
        	fVal = fVal + sum - n * A[i];
        	result = Math.max(result, fVal);
        }
        return result;
    }
}
