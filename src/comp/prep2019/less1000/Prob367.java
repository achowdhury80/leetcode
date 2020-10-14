package comp.prep2019.less1000;

public class Prob367 {
	public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num < 2) return true;
        int l = 2, h = num / 2;
        while(l <= h) {
        	int mid = l + (h - l) / 2;
        	long prod = (mid + 0l) * mid;
        	if (prod == num) return true;
        	if (prod < num) l = mid + 1;
        	else h = mid - 1;
        }
        return false;
    }
}
