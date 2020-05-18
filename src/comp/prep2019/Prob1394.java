package comp.prep2019;

public class Prob1394 {
	public int findLucky(int[] arr) {
        int[] a = new int[501];
        int result = -1;
        for (int i : arr) {
        	a[i]++;
        }
        for (int i = 500; i > 0; i--) {
        	if (a[i] == i) {
        		result = i;
        		break;
        	}
        }
        return result;
    }
}
