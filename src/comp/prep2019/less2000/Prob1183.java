package comp.prep2019.less2000;
import java.util.*;
public class Prob1183 {
	public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[] sq = new int[sideLength * sideLength];
		for (int i = 0; i < height; i += sideLength) {
			for (int j = 0; j < width; j += sideLength) {
				for (int x = 0; x < sideLength * sideLength; x++) {
					int row = x / sideLength;
					int col = x % sideLength;
					if (i + row < height && j + col < width) sq[x]++;
				}
			}
		} 
		Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
		for (int i : sq) q.offer(i);
		int result = 0;
		int i = 0;
		while(i < maxOnes && !q.isEmpty()) {
			int cur = q.poll();
			result += cur;
			i++;
		}
		return result;
    }
}
