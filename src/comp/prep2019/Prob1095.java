package comp.prep2019;
import java.util.*;
public class Prob1095 {
	public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        Map<Integer, Integer> cache = new HashMap<>();
        int first = getVal(mountainArr, cache, 0), last = getVal(mountainArr, cache, n - 1);
        if (first == target) return 0;
        int[] pivot = findPivot(0, first, n - 1, last, mountainArr, cache);
        int result = find(target, 0, first, pivot[0], pivot[1], mountainArr, true,
        		cache);
        if (result > -1) return result;
        return find(target, pivot[0], pivot[1], n - 1, last, mountainArr, false,
        		cache);
    }
	
	private int getVal(MountainArray mountainArr, Map<Integer, Integer> cache, 
			int index) {
		if (!cache.containsKey(index)) cache.put(index, mountainArr.get(index));
		return cache.get(index);
	}
	
	private int[] findPivot(int startIndex, int start, int endIndex, int end,
			MountainArray mountainArr, Map<Integer, Integer> cache) {
		if (startIndex == endIndex) return new int[] {startIndex, start};
		if(startIndex < endIndex - 1) {
			int midIndex = startIndex + (endIndex - startIndex) / 2;
			int midVal = getVal(mountainArr, cache, midIndex);
			if (midVal <= start) {
				return findPivot(startIndex, start, midIndex, midVal, 
						mountainArr, cache);
			} else {
				int nextVal = getVal(mountainArr, cache, midIndex + 1);
				if (nextVal < midVal)
					return findPivot(startIndex, start, midIndex, midVal, 
						mountainArr, cache);
				return findPivot(midIndex, midVal, endIndex, end, 
						mountainArr, cache);
			}
		}
		if (start > end) return new int[] {startIndex, start};
		return new int[] {endIndex, end};
	}
	
	private int find(int target, int firstIndex, int first, int lastIndex, int last,
			MountainArray mountainArr, boolean increasing, 
			Map<Integer, Integer> cache) {
		if (first == target) return firstIndex;
		if (last == target) return lastIndex;
		if (lastIndex - firstIndex < 2) return -1;
		int midIndex = firstIndex + (lastIndex - firstIndex) / 2;
		int midVal = getVal(mountainArr, cache, midIndex);
		if (midVal == target) return midIndex;
		if (increasing) {
			if (midVal > target) return find(target, firstIndex, first, midIndex, 
					midVal,
					mountainArr, true, cache);
			else return find(target, midIndex, midVal, lastIndex, last,
					mountainArr, true, cache);
		} else {
			if (midVal > target) return find(target, midIndex, midVal, lastIndex, 
					last, mountainArr, false, cache);
			else return find(target, firstIndex, first, midIndex, midVal,
					mountainArr, false, cache);
		}
	}
	
	
	
	public static void main(String[] arhs) {
		Prob1095 prob = new Prob1095();
		
		System.out.println(prob.findInMountainArray(2, new Mount()));
	}
	 
}

interface MountainArray {
    public int get(int index);
     public int length();
 }

class Mount implements MountainArray{
	 int[] arr = new int[] {1, 5, 2};
		public int get(int index) {
			return arr[index];
		}
	      public int length() {
	    	  return arr.length;
	      }
}
