package comp.prep2019.less1000;

public class Prob275 {
	public int hIndex(int[] citations) {
		int n = citations.length;
		if (n < 1) return 0;
		int low = 0, high = citations.length - 1;
		while(low < high) {
			int mid = low + (high - low) / 2;
			if (citations[mid] >= n - mid) high = mid;
			else low = mid + 1;
		}
		return citations[high] >= n - high ? n - high: 0;
    }
}
