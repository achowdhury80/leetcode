package comp.prep2019;

public class Prob1453 {
	public int numPoints(int[][] A, int r) {
        int res = 1, n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = A[i][0], y1 = A[i][1];
                int x2 = A[j][0], y2 = A[j][1];
                double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                if (d > r * 2) continue;
                double x0 = (x1 + x2) / 2.0 + (y2 - y1) * Math.sqrt(r * r - d * d / 4) / d;
                double y0 = (y1 + y2) / 2.0 - (x2 - x1) * Math.sqrt(r * r - d * d / 4) / d;
                int cnt = 0;
                for (int[] point: A) {
                    double x = point[0], y = point[1];
                    if ((x - x0) * (x - x0) + (y - y0) * (y - y0) <= r * r + 0.00001) {
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
