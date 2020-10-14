package comp.prep2019.less1000;

public class Prob69 {
	/**
	 * O(logn)
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
        if (x < 2) return x;
        int l = 1, h = x / 2;
        while(l < h) {
        	int mid = l + (h - l) / 2;
        	long prod = (mid + 0l) * mid;
        	if (prod == x) return mid;
        	if (prod > x) h = mid - 1;
        	else l = mid + 1;
        }
        return (l + 0l) * l > x ? l - 1 : l;
    }
}
