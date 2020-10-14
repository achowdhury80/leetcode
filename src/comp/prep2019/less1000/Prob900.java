package comp.prep2019.less1000;

public class Prob900 {
	private int[] A;
	private int idx;
	public Prob900(int[] A) {
        this.A = A;
        idx = 0;
    }
    
    public int next(int n) {
    	if (idx >= A.length) return -1;
        while(A[idx] < n) {
        	n -= A[idx];
        	idx += 2;
        	if (idx >= A.length) return -1;
        }
        int result = 0;
        if (A[idx] == n) {
        	result = A[idx + 1];
        	idx += 2;
        } else {
        	A[idx] -= n;
        	result = A[idx + 1];
        }
        return result;
    }
}
