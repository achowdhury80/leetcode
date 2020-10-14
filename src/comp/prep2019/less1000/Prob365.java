package comp.prep2019.less1000;

public class Prob365 {
	public boolean canMeasureWater(int x, int y, int z) {
		if(z > x + y) return false;
	    if(z == x || z == y || z == x + y) return true;
        return z % findHcf(x, y) == 0;
    }
	
	private int findHcf(int a, int b) {
		if (b == 0) return a;
		if (b > a) return findHcf(b, a);
		return findHcf(b, a % b);
	}
}
