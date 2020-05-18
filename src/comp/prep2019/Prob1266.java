package comp.prep2019;

public class Prob1266 {
	/**
	 * O(N)
	 * for any two points, find the diff for x and y
	 * move diagonally as much as possible
	 * max diagonal move = min(xDis, yDis)
	 * add the remaining move
	 * @param points
	 * @return
	 */
	public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        if (n < 2) return 0;
        int cur = 0;
        int result = 0;
        while(cur + 1 < n) {
        	int xDis = Math.abs(points[cur][0] - points[cur + 1][0]), yDis = Math.abs(points[cur][1] - points[cur + 1][1]);
        	int min;
        	result += (min = Math.min(xDis, yDis)) + xDis - min + yDis - min;
        	cur++;
        }
        return result;
    }
}
