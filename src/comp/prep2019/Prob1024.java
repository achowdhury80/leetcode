package comp.prep2019;

import java.util.Arrays;

public class Prob1024 {
	public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (x, y) -> (x[0] == y[0]) ? (y[1] - x[1]) : (x[0] - y[0]));
        int result = 0;
        int start = 0;
        for (int i = 0; i < clips.length; i++) {
        	if (clips[i][1] <= start) continue;
        	if (clips[i][0] > start) return -1;
        	int lastEnd = Integer.MIN_VALUE;
        	while (i < clips.length && clips[i][0] <= start) {
        		lastEnd = Math.max(lastEnd, clips[i][1]);
        		i++;
        	}
        	result++;
        	i--;
        	if (T <= lastEnd) return result;
    		else start = lastEnd;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Prob1024 prob = new Prob1024();
		System.out.println(prob.videoStitching(new int[][]{{0,1},{6,8},{0,2},{5,6},
			{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},
			{4,5},{5,7},{6,9}}, 9));
		
		System.out.println(prob.videoStitching(new int[][]{{0,2},{4,6},{8,10},{1,9},
			{1,5},{5,9}}, 10));
	}
}
