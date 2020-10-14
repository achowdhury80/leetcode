package comp.prep2019.less1000;

public class Prob962 {
	public int maxWidthRamp(int[] A) {
        int[] arr = new int[50001];
        int max = -1;
        for (int i = 0; i < A.length; i++) {
        	max = Math.max(max, A[i]);
        	// 1 based earliest index
        	if (arr[A[i]] == 0) arr[A[i]] = i + 1;
        }
        int minIndexSoFar = Integer.MAX_VALUE;
        //now arr[i] is the smallest(1 based) index of elements from value 0 to i.
        for (int i = 0; i <= max; i++) {
        	if (arr[i] == 0) continue;
        	arr[i] = Math.min(minIndexSoFar, arr[i]);
        	minIndexSoFar = arr[i];
        }
        int result = Integer.MIN_VALUE;
        // now for all elements, find out the smallest 1 based index of elements 
        // from 0 to that elemt
        for (int i = 0; i < A.length; i++) {
        	if (arr[A[i]] != i + 1) result = Math.max(result, (i + 1) - arr[A[i]]);
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }
	
	public static void main(String[] args) {
		Prob962 prob = new Prob962();
		System.out.println(prob.maxWidthRamp(new int[] {6,0,8,2,1,5}));
	}
}
