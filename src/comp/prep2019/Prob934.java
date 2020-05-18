package comp.prep2019;
import java.util.*;
public class Prob934 {
	public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        Queue<int[]> q = new LinkedList<>(), q1 = new LinkedList<>();;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
        	boolean flag = false;
        	for (int j = 0; j < n; j++) {
        		if (A[i][j] == 1) {
        			q.offer(new int[] {i, j});
        			q1.offer(new int[] {i, j});
        			A[i][j] = -1;
        			while(!q.isEmpty()) {
        				int[] cur = q.poll();
        				for (int[] dir : dirs) {
        					int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        					if (next[0] > - 1 && next[0] < m && next[1] > - 1 
        							&& next[1] < n && A[next[0]][next[1]] == 1) {
        						q.offer(next);
        						q1.offer(next);
        						A[next[0]][next[1]] = -1;
        					}
        				}
        			}
        			flag = true;
        			break;
        		}
        	}
        	if (flag) break;
        }
        int result = -1;
        while(!q1.isEmpty()) {
        	int size = q1.size();
        	result++;
        	for (int i = 0; i < size; i++) {
        		int[] cur = q1.poll();
				for (int[] dir : dirs) {
					int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
					if (next[0] > - 1 && next[0] < m && next[1] > - 1 
							&& next[1] < n) {
						if (A[next[0]][next[1]] == 1) return result;
						if (A[next[0]][next[1]] == 0) {
							q1.offer(next);
							A[next[0]][next[1]] = -2;
						}
						
					}
				}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob934 prob = new Prob934();
		System.out.println(prob.shortestBridge(new int[][] {{0,1},{1,0}}));
	}
}
