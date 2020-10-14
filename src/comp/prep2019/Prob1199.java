package comp.prep2019;
import java.util.*;
public class Prob1199 {
	/**
	 * https://leetcode.com/problems/minimum-time-to-build-blocks/discuss/387035/Python%3A-O(n-log-n)-using-Huffman's-Algorithm-(priority-queue)-with-explanation.
	 * @param blocks
	 * @param split
	 * @return
	 */
	public int minBuildTime(int[] blocks, int split) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int block : blocks) q.offer(block);
        while(q.size() > 1) {
        	int smaller = q.poll();
        	int bigger = q.poll();
        	q.offer(bigger + split);
        }
        return q.poll();
    }
}
