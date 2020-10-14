package comp.prep2019.less1000;

public class Prob945 {
	public int minIncrementForUnique(int[] A) {
        int[] arr = new int[40000 + A.length];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int a : A) {
        	arr[a]++;
        	min = Math.min(min, a);
        	max = Math.max(max, a);
        }
        int result = 0;
        for (int i = min; i <= max; i++) {
        	int freeIndex = i;
        	while(arr[i] > 1) {
        		for(int j = Math.max(i + 1, freeIndex); j < arr.length; j++) {
        			if (arr[j] == 0) {
        				freeIndex = j;
        				break;
        			}
        		}
        		result += freeIndex - i;
        		arr[freeIndex] = 1;
        		arr[i]--;
        	}
        }
        return result;
    }
}
