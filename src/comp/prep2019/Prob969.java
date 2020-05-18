package comp.prep2019;
import java.util.*;
public class Prob969 {
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> result = new ArrayList<>();
		int i = A.length - 1;
        while(true) {
        	while(i > - 1 && A[i] == i + 1) i--;
        	if (i < 0) break;
        	int j = i - 1;
        	while(A[j] != i + 1) j--;
        	reverse(A, 0, j);
        	result.add(j + 1);
        	reverse(A, 0, i);
        	result.add(i + 1);
        	i--;
        }
        return result;
    }
	
	private void reverse(int[] A, int start, int end) {
		while(start < end) {
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			start++; 
			end--;
		}
	}
}
