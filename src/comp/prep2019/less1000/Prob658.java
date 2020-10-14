package comp.prep2019.less1000;
import java.util.*;
public class Prob658 {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int n = arr.length;
        int pos = Arrays.binarySearch(arr, x);
        int smaller = -1, larger = n;
        if (pos >= 0) {
        	smaller = pos;
        	larger = pos + 1;
        } else {
        	smaller = -(pos + 1) - 1;
        	larger = smaller + 1;
        }
        List<Integer> result = new ArrayList<>();
        while(result.size() < k) {
        	if (smaller == -1) result.add(arr[larger++]);
        	else if (larger == n) result.add(0, arr[smaller--]);
        	else {
        		if (x - arr[smaller] <= arr[larger] - x) {
        			result.add(0, arr[smaller--]);
        		} else result.add(arr[larger++]);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob658 prob = new Prob658();
		System.out.println(prob.findClosestElements(new int[] {0,0,1,2,3,3,4,7,7,8},
				3,5));	
	}
}
