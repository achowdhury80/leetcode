package comp.prep2019;

public class Prob1053 {
	public int[] prevPermOpt1(int[] A) {
        for (int i = A.length - 2; i > -1; i--) { 
        	if (A[i] > A[i + 1]) {
        		// find max less than A[i]. Swap them
        		for (int j = A.length - 1; j > i; j--) {
        			if (A[j] < A[i]) {
        				for (int k = j - 1; k > i; k--) {
        					if (A[k] == A[j]) {
        						j = k;
        					} else break;
        				}
        				int temp = A[i];
        				A[i] = A[j];
        				A[j] = temp;
        				return A;
        			} 
        		}
        	}
        }
        return A;
    }
	
	public static void main(String[] args) {
		Prob1053 prob = new Prob1053();
		int[] arr = prob.prevPermOpt1(new int[] {3,1,1,3});
		for (int a : arr) System.out.print(a + ", ");
	}
}
