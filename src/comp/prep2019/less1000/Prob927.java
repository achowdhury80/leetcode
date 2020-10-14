package comp.prep2019.less1000;

public class Prob927 {
	/**
	 * o(n)
	 * find total one count
	 * fix on rightmost portion with one count
	 * that will give trailing zero count
	 * fix the first portion with one count and trailing zeros
	 * fix the middle portion with trailing zeros
	 * compare all  the portions for equality
	 * @param A
	 * @return
	 */
	public int[] threeEqualParts(int[] A) {
		int[] result = new int[] {-1, -1};
        int oneCount = 0;
        for (int a : A) if (a == 1) oneCount++;
        if (oneCount == 0) return new int[] { 0, 2};
        if (oneCount % 3 != 0) return result;
        int oneCountInPart = oneCount / 3;
        int j = -1, count = 0;
        int lastZeroCount = 0;
        for (j = A.length - 1; j > 1 && count < oneCountInPart; j--) {
        	if (A[j] == 1) count++;
        	else if (count < 1) lastZeroCount++;
        }
        j++;
        int i = 0;
        count = 0;
        for (i = 0; i < A.length - 2 && count < oneCountInPart; i++) {
        	if (A[i] == 1) count++;
        }
        i--;
        for (int x = 0 ; x < lastZeroCount; x++) {
        	i++;
        	if (A[i] == 1) return result;
        }
        count = 0;
        int x = 0;
        for (x = i + 1; x < j && count < oneCount / 3; x++) {
        	if (A[x] == 1) count++;
        }
        x--;
        for (int k = 0 ; k < lastZeroCount; k++) {
        	x++;
        	if (x == j || A[x] == 1) return result;
        }
        j = x + 1;
        
        if (compare(A, 0, i + 1, j - 1, oneCountInPart) 
        		&& compare(A, i + 1, j, A.length - 1, oneCountInPart)) {
        	result[0] = i; 
        	result[1] = j;
        }
        return result;
        
    }
	
	private boolean compare(int[] A, int s1, int s2, int e2, int oneCount) {
		int c = 0;
		for (int i = s2 - 1, j = e2; c < oneCount; i--, j--) {
			if (A[i] != A[j]) return false;
			if (A[i] == 1) c++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Prob927 prob = new Prob927();
		//int[] arr = prob.threeEqualParts(new int[] {1, 0, 1, 0, 1});
		int[] arr = prob.threeEqualParts(new int[] {0,1,0,1,1,0,1,1,0,1});
		for (int i = 0; i < arr.length; i++) System.out.println(arr[i]);
	}
}
