package comp.prep2019.less1000;

public class Prob961 {
	/**
	 * in atleast one of all set of 3 consequtive elements, the element will be 
	 * repeated twice
	 * except for 4 items array [1,2,2,1] - here you need to check for terminal 
	 * element
	 * @param A
	 * @return
	 */
	public int repeatedNTimes(int[] A) {
        int[] arr= new int[] {A[0], A[1], A[2]};
        int result = commonItem(arr);
        if(result != -1) return result;
        for (int i = 3; i < A.length; i++) {
        	arr[0] = arr[1];
        	arr[1] = arr[2];
        	arr[2] = A[i];
        	result = commonItem(arr);
            if(result != -1) return result;
        }
        return A.length == 4 && A[0] == A[A.length - 1] ? A[0] : -1;
    }
	
	private int commonItem(int[] A) {
		if (A[0] == A[1] || A[1] == A[2]) return A[1];
        else if(A[0] == A[2]) return A[0];
		return -1;
	}
}
