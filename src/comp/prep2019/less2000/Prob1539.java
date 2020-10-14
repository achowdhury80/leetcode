package comp.prep2019.less2000;

public class Prob1539 {
	
	public int findKthPositive(int[] arr, int k) {
		int l = 0, r = arr.length;
		while(l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] - mid - 1 < k) {
				l = mid + 1;
			} else r = mid;
		}
		return k + l;
		
    }
	
	public int findKthPositive1(int[] arr, int k) {
		int last = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (last + k < arr[i]) return last + k;
        	k -= arr[i] - last - 1;
        	last = arr[i];
        }
        return last + k;
    }
}
