package comp.prep2019;

public class Prob836 {
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return overlapExists(new int[] {rec1[0], rec1[2]}, new int[] {rec2[0], rec2[2]})
        		&& overlapExists(new int[] {rec1[1], rec1[3]}, new int[] {rec2[1], rec2[3]});
    }
	private boolean overlapExists(int[] a, int[] b) {
		if (a[0] <= b[0]) return a[1] > b[0];
		else return b[1] > a[0];
	}
}
